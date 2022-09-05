package MIU;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyAutoWiredInjector {
    @MyAutowired(name = "CustomField1 annotation name")
    public static String CustomField1;
    private static Map<Class, Object> container = new HashMap<>();

    public static void scanForBeans() {
        System.out.println("Scanning using Reflection.......");
        Reflections ref = new Reflections("MIU",
                new SubTypesScanner(),
                new TypeAnnotationsScanner(),
                new FieldAnnotationsScanner());

        for (Field f : ref.getFieldsAnnotatedWith(MyAutowired.class)) {
            MyAutowired myAutowired = f.getAnnotation(MyAutowired.class);
            container.put(f.getDeclaringClass(), myAutowired.name());
        }
    }

    public static void getBean(Class<?> clazz) throws BeanNotFoundException {
        System.out.println("Finding clazzes........");
        if(!container.containsKey(clazz)) {
            throw new BeanNotFoundException("Could not find the MyAutoWired annotation! in " + clazz.getSimpleName() + "class");
        } else {
            System.out.printf("Found class: %s, using MyAutoWired annotation: %n", clazz.getSimpleName());
        }
    }

    public static void main(String[] args) throws BeanNotFoundException {
        scanForBeans();
        getBean(TestAutoWired.class);
        getBean(MyAutoWiredInjector.class);
        getBean(TestMyBean.class);
    }
}
