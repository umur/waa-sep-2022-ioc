package edu.miu.lab1.basic;

import edu.miu.lab1.advanced.exception.BeanNotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MyInjector {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        initialize();
    }

    public static Object getBean(Class<?> clazz) {
        if(!BEAN_MAP.containsKey(clazz)) {
            throw new BeanNotFoundException("Cannot find bean " + clazz);
        }
        return BEAN_MAP.get(clazz);
    }

    private static void initialize() {
        var classes = ClassFinder.find("edu.miu.lab1.basic");
        for (Class<?> cl : classes) {
            if (cl.isAnnotationPresent(MyBean.class)) {
                try {
                    BEAN_MAP.putIfAbsent(cl, cl.getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |  NoSuchMethodException e) {
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
