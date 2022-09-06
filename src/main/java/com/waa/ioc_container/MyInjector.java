package com.waa.ioc_container;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {
    Map<Class, Object> beans = new HashMap<>();
    public MyInjector(final String packageName) {
        System.out.println("scanning package - " + packageName);

        Set<Class> classSet = findAllClassesUsingClassLoader(packageName);

        for (Class beanClass: classSet) {
            try {
                Field[] fields = beanClass.getDeclaredFields();

                for (Field field: fields) {
                    if (field.isAnnotationPresent(MyAutowired.class)) {
                        Class<?> fieldType = field.getType();

                        if (fieldType.isAnnotationPresent(MyBean.class)) {
                            Constructor<?> constructor = fieldType.getConstructor();
                            System.out.println(fieldType.getName());
                            beans.put(fieldType, constructor.newInstance());
                        }
                    }
                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method was gotten from https://www.baeldung.com/java-find-all-classes-in-package
     *
     * @param packageName - the name of the package to be scanned
     * @return Set<Class>
     */
    public Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    public <T> T getBean(Class<T> beanClass) {
        // add validations and return
        Object object = beans.get(beanClass);

        if (object == null) {
            throw new BeanNotFoundException("No bean for class " + beanClass.getName() + " found in context.");
        }

        return (T) object;
    }
}
