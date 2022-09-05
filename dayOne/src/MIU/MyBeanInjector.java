package MIU;

import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;

@MyBean(name="MyBean annotated itself")
public class MyBeanInjector {
    private static Map<Class, Object> container = new HashMap<>();

    public static void scanForBeans() {
        System.out.println("Scanning using Reflection.......");
        Reflections ref = new Reflections("MIU");
        for (Class<?> cl : ref.getTypesAnnotatedWith(MyBean.class)) {
            MyBean mybean = cl.getAnnotation(MyBean.class);
            container.put(cl, mybean.name());
        }
    }

    public static void getBean(Class<?> clazz) throws BeanNotFoundException {
        System.out.println("Finding clazzes........");
        if(!container.containsKey(clazz)) {
            throw new BeanNotFoundException("Could not find the MyBean annotation! in " + clazz.getSimpleName() + "class");
        } else {
            System.out.printf("Found class: %s, using MyBean annotation: %s%n", clazz.getSimpleName(), clazz.getAnnotation(MyBean.class));
        }
    }

    public static void main(String[] args) throws BeanNotFoundException {
        scanForBeans();
        getBean(TestMyBean.class);
        getBean(MyBeanInjector.class);
        getBean(MyAutoWiredInjector.class);
    }
}
