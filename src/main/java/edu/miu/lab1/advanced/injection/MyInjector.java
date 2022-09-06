package edu.miu.lab1.advanced.injection;

import edu.miu.lab1.advanced.annotation.MyAutowired;
import edu.miu.lab1.advanced.annotation.MyBean;
import edu.miu.lab1.advanced.annotation.MyComponentScan;
import edu.miu.lab1.advanced.exception.BeanNotFoundException;
import edu.miu.lab1.advanced.util.ClassFinder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyInjector implements BeanInjector {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    public static Object getBean(Class<?> clazz) {
        if(!BEAN_MAP.containsKey(clazz)) {
            throw new BeanNotFoundException("Cannot find bean " + clazz);
        }
        return BEAN_MAP.get(clazz);
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
                    BEAN_MAP.putIfAbsent(cl, cl.getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }

                Field[] fields = cl.getDeclaredFields();
                for(Field field : fields) {
                    if(field.getAnnotation(MyAutowired.class) != null) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        try {

                            BEAN_MAP.putIfAbsent(type, type.getConstructor().newInstance());
                            Object currentObj= BEAN_MAP.get(cl);
                            Object newValue = BEAN_MAP.get(type);
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
