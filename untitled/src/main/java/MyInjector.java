import org.reflections.Reflections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class MyInjector {
    Map<Class<?>, Object> map = new Hashmap<>();
    public MyInjector(){
        Reflections reflections = new Reflections("java");
        reflections.getTypeAnnotatedWith(MyBean.class).forEach(aClass -> {
            try{
                Object t = aClass.newInstance();
                Arrays.stream(aClass.getFields()).filter(f->f.isAnnotationPresent(MyAutowired.class))
                        .toList()
                        .forEach(field ->{
                            Class<?> innerClass= filed.getType();
                        });
                map.put(aClass, t);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public Object getBean(Class<?> clazz) throws NotFoundBeanException {
        try {
            return map.get(clazz);
        } catch (Exception e) {
            throw new NotFoundBeanException("Error");
        }
    }
}