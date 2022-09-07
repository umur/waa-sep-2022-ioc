package reflection;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyInjector {
    static Map<Class, Object> container = new HashMap<>();

    Set<Class<?>> annotatedClasses;
    Set<Field> fields;


    public void scan() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Reflections reflections = new Reflections("reflection", new SubTypesScanner(), new TypeAnnotationsScanner(), new FieldAnnotationsScanner());
        annotatedClasses = reflections.getTypesAnnotatedWith(MyBean.class);
        fields = reflections.getFieldsAnnotatedWith(MyAutowired.class);

        for (Class<?> claz : annotatedClasses) {
            Object c = claz.getDeclaredConstructor().newInstance();
            container.put(claz, c);
        }

    }

    public void injectAnnotatedFields() throws IllegalAccessException {
        for(Field field: fields){

            Object declaringClass = field.getDeclaringClass();
            Object fieldType = field.getType();

            Object classObject = container.get(declaringClass);
            Object fieldObject = container.get(fieldType);

            field.setAccessible(true);
            field.set(classObject, fieldObject);
            System.out.println();
        }

    }

    public Object getBean(Class<?> declaringClass) throws BeanNotFoundException {
        if (container.containsKey(declaringClass)) {
            return container.get(declaringClass);
        }else {
            throw new BeanNotFoundException();
        }
    }
}
