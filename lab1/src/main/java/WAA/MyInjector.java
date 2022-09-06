package WAA;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {
    private Map<Class, Object> classMap;

    MyInjector(){
        classMap = new HashMap<Class, Object>();
    }

    public void searchObjects(){
        Reflections reflections = new Reflections("WAA");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(MyBean.class);

        classes.stream()
                .filter(c -> Arrays.stream(c.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(MyAutowired.class))
                .collect(Collectors.toSet()).size() > 0
                ).forEach(c -> {
                    try{
                        Constructor cons = c.getDeclaredConstructor();
                        cons.setAccessible(true);
                        Object obj = cons.newInstance();
                        classMap.put(c, obj);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                });
        classes.stream().forEach(c -> {
            for(Field field: c.getDeclaredFields()){
                try{
                    Object beanObj = this.getBean(c);
                    Constructor cons = field.getClass().getDeclaredConstructor();
                    cons.setAccessible(true);
                    Object value = cons.newInstance();
                    field.set(beanObj, value);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public Object getBean(Class clazz) throws BeanNotFoundException{
        if(!classMap.containsKey(clazz)){
            throw new BeanNotFoundException(("Bean not found for class" + clazz.getSimpleName()));
        }
        return classMap.get(clazz);
    }
}
