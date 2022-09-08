package mypackage;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {
    // Map
    public HashMap<Class, Object> ioc = new HashMap<>();


    //Search through package

    //find class with annotation
    //put in the map

    public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));

    }

    public void addToIOC() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Set<Class> setOFClasses = findAllClassesUsingReflectionsLibrary("mypackage");

        for (Class c : setOFClasses) {
            if (c.isAnnotationPresent(MyBean.class)) {
                ioc.put(c, c.getDeclaredConstructor().newInstance());
            }
        }

//        findAllClassesUsingReflectionsLibrary("mypackage")
//                .stream()
//                .filter(aClass -> aClass.isAnnotationPresent(MyBean.class))
//                .forEach(aClass -> ioc.put(aClass,aClass.getDeclaredConstructor().newInstance()));


    }

    public void createInstance() throws IllegalAccessException {
        Set<Class> setOFClasses = findAllClassesUsingReflectionsLibrary("mypackage");

        for (Class c : setOFClasses) {

            for (Field field : c.getDeclaredFields()) {

                if (field.isAnnotationPresent(MyAutowired.class)) {

                    if (ioc.containsKey(field.getType())) {
                        field.setAccessible(true);
                        field.set(ioc.get(field.getDeclaringClass()), ioc.get(field.getType()));


                    }
                }

            }
        }


    }

    public Object getBean(Class clazz) {
        if (ioc.get(clazz) == null) throw new BeanNotFoundException("Bean Not Found");
        return ioc.get(clazz);

    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        MyInjector injector = new MyInjector();
        injector.addToIOC();
        injector.createInstance();

        ClassB classB = (ClassB) injector.getBean(ClassB.class);
        classB.call();

    }

}
