package iocsample;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyInjector {
    private final static Map<Class, Object> anotationStore = new HashMap<>();

    private MyInjector() {}

    public static void run(Class mainClazz) {
        String packageName = mainClazz.getPackageName();
        try {
            loadBeans(packageName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadBeans(String packageName) throws IOException {
        Predicate<ClassPath.ClassInfo> beanClassFilter = clazz -> clazz
                .getPackageName().contains(packageName) &&
                (clazz.load().isAnnotationPresent(MyBean.class) ||
                        Arrays.stream(clazz.load().getDeclaredFields()).anyMatch(field -> field.isAnnotationPresent(MyAutowired.class)));

        findAllClassesBy(beanClassFilter).forEach(MyInjector::wireBean);
    }

    private static void createInstance(Class beanClass) {
        anotationStore.computeIfAbsent(beanClass, (b) -> {
            try {
                return b.getConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void wireBean(Class beanClass) {
        createInstance(beanClass);
        Arrays.stream(beanClass.getDeclaredFields()).filter(f -> f.isAnnotationPresent(MyAutowired.class))
                .forEach(f -> {
                    f.setAccessible(true);
                    try {
                        createInstance(f.getType());
                        f.set(getBean(beanClass), getBean(f.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static Stream<Class> findAllClassesBy(Predicate<ClassPath.ClassInfo> predicate) throws IOException {
        return ClassPath.from(ClassLoader.getSystemClassLoader())
                .getAllClasses()
                .stream()
                .filter(predicate)
                .map(clazz -> clazz.load());
    }

    public static Object getBean(Class<?> clazz) {
        if(!anotationStore.containsKey(clazz)) throw new BeanNotFoundException();
        return anotationStore.get(clazz);
    }
}
