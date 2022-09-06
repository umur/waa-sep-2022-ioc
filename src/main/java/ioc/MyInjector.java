package ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class MyInjector {
    HashMap<Class<?>, Object> injectMap = new HashMap<>();
    private static final String PACKAGE_TO_SCAN = "ioc";

    public MyInjector() {
        List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);

        for (Class<?> cl : classes) {
            if (cl.isAnnotationPresent(MyBean.class)) {
                try {
                    Object obj = cl.getConstructor().newInstance();
                    injectMap.putIfAbsent(cl, obj);

                    for (Field field : cl.getDeclaredFields()) {
                        if (field.isAnnotationPresent(MyAutowired.class)) {
                            field.setAccessible(true);
                            Class<?> type = field.getType();
                            Object typeObj = type.getConstructor().newInstance();
                            injectMap.putIfAbsent(type, typeObj);
                            field.set(injectMap.get(cl), injectMap.get(type));
                        }
                    }
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                         NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public Object getBean(Class<?> clazz) throws BeanNotFoundException {
        try {
            return injectMap.get(clazz);
        } catch (Exception ex) {
            throw new BeanNotFoundException("Cannot find bean");
        }
    }
}
