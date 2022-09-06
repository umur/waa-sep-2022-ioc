import annotations.MyAutowired;
import annotations.MyBean;
import exceptions.BeanNotFoundException;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MyInjector {
    HashMap<String, Object> myClassMap;

    public MyInjector() {
        myClassMap = new HashMap<>();
    }

    public Object getBean(Class clazz) throws BeanNotFoundException {
        if (myClassMap.get(clazz.getSimpleName()) != null) {
            return myClassMap.get(clazz.getSimpleName());
        }
        throw new BeanNotFoundException("Class not Found !!!");
    }

    public static void main(String[] args) throws BeanNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Started Scanning the package...");
        MyInjector inj = new MyInjector();
        Package p = inj.getClass().getPackage();
        System.out.println(p.getName());
        Reflections r = new Reflections("");
        for (Class<?> cl : r.getTypesAnnotatedWith(MyBean.class)) {
            for (Field field : cl.getDeclaredFields()) {
                if (field.isAnnotationPresent(MyAutowired.class)) {
                    inj.myClassMap.put(cl.getSimpleName(), cl.newInstance());
                    System.out.printf("Found class: %s %n", cl.getSimpleName());
                }
            }
        }

        System.out.println(inj.myClassMap.toString());

        Object obj1 = inj.getBean(TestClassA.class);
        Object obj2 = inj.getBean(TestClassB.class);

    }
}
