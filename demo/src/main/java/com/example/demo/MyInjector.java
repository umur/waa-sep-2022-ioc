package com.example.demo;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MyInjector {
    static Map<Class, Object> container = new HashMap<>();

    Set<Field> fields;

    public void scanBeans() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Reflections reflections = new Reflections("", new SubTypesScanner(), new TypeAnnotationsScanner(), new FieldAnnotationsScanner());

        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(MyBean.class);
        fields = reflections.getFieldsAnnotatedWith(MyAutowired.class);

        for (Class<?> clazz : annotatedClasses) {
            Object c = clazz.getDeclaredConstructor().newInstance();
            container.put(clazz, c);
        }
    }

    public void injectFields() throws IllegalAccessException {
        for(Field field: fields) {
            Object className = field.getDeclaringClass();
            Object fieldType = field.getType();

            Object classObject = container.get(className);
            Object fieldObject = container.get(fieldType);

            field.setAccessible(true);
            field.set(classObject, fieldObject);
            System.out.println();
        }
    }

    public Object getBean(Class<?> declaringClass) throws BeanNotFoundException {
        if (container.containsKey(declaringClass)) {
            return container.get(declaringClass);
        } else {
            throw new BeanNotFoundException();
        }
    }
}
