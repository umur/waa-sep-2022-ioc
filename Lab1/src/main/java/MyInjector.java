import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Field;
import java.util.*;

public class MyInjector {

    private Map<String, Object> mapsData = new HashMap<>();
    MyInjector() throws Exception {
        injectStart();
    }
    private void injectStart() throws Exception {
        ConfigurationBuilder beanBuild = new ConfigurationBuilder();
        beanBuild.setScanners(Scanners.TypesAnnotated);
        beanBuild.setUrls(ClasspathHelper.forPackage("."));

        Reflections beansReflect = new Reflections(beanBuild);
        Set<Class<?>> classes = beansReflect.getTypesAnnotatedWith(MyBean.class);
        for (Class<?> c: classes) {
            Object object = getFromMap(c, c.getDeclaredConstructor().newInstance());
            putIntoMap(c, object);

            Field[] fields = c.getDeclaredFields();

            for (Field field: fields) {
                if (field.getDeclaredAnnotationsByType(MyAutowired.class).length > 0) {
                    Class<?> fieldClass = field.getType();
                    Object fieldObject = getFromMap(fieldClass, fieldClass.getDeclaredConstructor().newInstance());
                    putIntoMap(fieldClass, fieldObject);
                    field.set(object, fieldObject);
                }
            }
        }
    }


    private Object getFromMap(Class<?> klass, Object defaultValue) {
        return mapsData.getOrDefault(klass.getSimpleName(), defaultValue);
    }

    private void putIntoMap(Class<?> klass, Object object) {
        mapsData.put(klass.getSimpleName(), object);
    }

    public <T> T getBeans(Class<T> klass) throws BeanNotFoundException {
        T o = (T)getFromMap(klass, null);
        if (o == null) {
            throw new BeanNotFoundException();
        }
        return o;
    }
}