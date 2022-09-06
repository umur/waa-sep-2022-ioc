package edu.miu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyInjector {

    private static final Map<Class<?>, Object> BEANS = new HashMap<>();

    static {
        List<Class<Object>> classes = Scanner.find("edu.miu");

        for (Class<Object> cl : classes) {
            if (cl.isAnnotationPresent(MyBean.class)) {
                try {
                    BEANS.putIfAbsent(cl, cl.getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }

                for (Field field : cl.getDeclaredFields()) {
                    if (field.isAnnotationPresent(MyAutowired.class)) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();

                        try {
                            BEANS.putIfAbsent(type, type.getConstructor().newInstance());
                            Object currentObj = BEANS.get(cl);
                            Object newValue = BEANS.get(type);
                            field.set(currentObj, newValue);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
        }
    }

    public static Object getBean(Class<?> clazz) throws BeanNotFoundException {
        if (!BEANS.containsKey(clazz)) {
            throw new BeanNotFoundException("Cannot find bean " + clazz);
        }
        return BEANS.get(clazz);
    }

}
