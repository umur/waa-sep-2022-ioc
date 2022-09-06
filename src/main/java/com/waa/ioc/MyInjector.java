package com.waa.ioc;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {
    // object container
    Map<String,Object> beans = new HashMap<>();
    // scan through annotations of @MyBean
    Class classA = ClassA.class;
    Class classB = ClassB.class;
    public MyInjector() {
        // scan objects
        Annotation annotation = classA.getAnnotation(MyBean.class);
        //this.beans.put(annotation.annotationType().getName(), annotation.annotationType());
       // this.beans.put(classB.getAnnotation(MyBean.class).annotationType().getName(), annotation.annotationType());
       // Set<Class> classes = findAllClassesUsingReflectionsLibrary("com.waa.ioc");
        // get current class package and use it as a scan directory
        Set<Class> classes = findAllClassesUsingClassLoader(getClass().getPackageName());
        classes.forEach(cls -> {
            // if (cls.getAnnotation(MyBean.class) != null)
                 beans.put(cls.getName(), cls);
        });
    }
   public  void printIoCClasses() {
        this.beans.entrySet().forEach(bean -> System.out.println(bean));
   }
    // get classes using reflections library
    public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Object.class)
                .stream()
                .collect(Collectors.toSet());
    }

    // using JRE's classLoader

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

}
