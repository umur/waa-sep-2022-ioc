package com.ultrates.lab1IoC.injection;

import com.ultrates.lab1IoC.ClassFinder;
import com.ultrates.lab1IoC.annotations.MyAutowired;
import com.ultrates.lab1IoC.annotations.MyBean;
import com.ultrates.lab1IoC.annotations.MyComponentScan;
import com.ultrates.lab1IoC.exception.BeanNotFoundException;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyInjector implements BeanInjector {
    private static final Map<Class<?>, Object> myBeenMAP = new HashMap<>();

    public static Object getBean(Class<?> clazz) {
        if(!myBeenMAP.containsKey(clazz)) {
            throw new BeanNotFoundException("Cannot find bean " + clazz);
        }
        return myBeenMAP.get(clazz);
    }

    public static void initialize(Class<?> clazz) {
        String basePackage = clazz.getPackageName();
        if(clazz.isAnnotationPresent(MyComponentScan.class)) {
            MyComponentScan myComponentScan = clazz.getAnnotation(MyComponentScan.class);
            basePackage = myComponentScan.value();
        }

        var classes = ClassFinder.find(basePackage);
        for (Class<?> cl : classes) {
            if (cl.isAnnotationPresent(MyBean.class)) {
                try {
                    myBeenMAP.putIfAbsent(cl, cl.getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }

                Field[] fields = cl.getDeclaredFields();
                for(Field field : fields) {
                    if(field.getAnnotation(MyAutowired.class) != null) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        try {

                            myBeenMAP.putIfAbsent(type, type.getConstructor().newInstance());
                            Object currentObj= myBeenMAP.get(cl);
                            Object newValue = myBeenMAP.get(type);
                            field.set(currentObj, newValue);
                        } catch(Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
        }
    }

}
