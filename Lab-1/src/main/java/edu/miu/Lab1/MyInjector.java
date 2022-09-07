package edu.miu.Lab1;

import com.sun.tools.jconsole.JConsoleContext;
import edu.miu.Lab1.annotations.MyAutowired;
import edu.miu.Lab1.exception.BeanNotFoundException;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class MyInjector {
    private Map<Class, Object> container = new HashMap<>();
    //https://stackoverflow.com/questions/259140/scanning-java-annotations-at-runtime

    public Set<Object> findAllClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Object getClass(String line, String packageName) {
        try {
            return Class.forName(packageName + "." + line.substring(0, line.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    private boolean hasAnnotation(Class cls) {
        List<Field> privateFields = new ArrayList<>();
        Field[] allField = cls.getDeclaredFields();
        for (Field f : allField) {
            if (Modifier.isPrivate(f.getModifiers())) {
                privateFields.add(f);
            }
        }
        for (Field f : privateFields) {
            if (f.isAnnotationPresent(MyAutowired.class)) {
                return true;
            }
        }
        return false;
    }

    public void scanForBean() throws Exception {
        Set<Object> classes = findAllClasses("lab1.main");
        for (Object cls : classes) {
            String thisClass = cls.toString().split(" ")[1];
            if (hasAnnotation(Class.forName(thisClass))) {
                container.put(Class
                                .forName(thisClass)
                        , Class.forName(thisClass)
                                .getConstructor()
                                .newInstance());
            }
        }
        //searches thru class
        //maps it to container
    }

    public Object getBean(Class clazz) throws BeanNotFoundException {
        try {
            return container.get(clazz);
        } catch (Exception ex) {
            throw new BeanNotFoundException("Bean Was Not Found!");
        }
    }
    //search every single class and find every autowire annotation
    //throw exception if not found
}
