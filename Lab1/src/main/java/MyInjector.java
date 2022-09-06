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
        Set<Class<?>> AllClasses = beansReflect.getTypesAnnotatedWith(MyBean.class);
        for (Class<?> c: AllClasses) {
            Object object = getFromMap(c, c.getDeclaredConstructor().newInstance());
            putIntoMap(c, object);

            Field[] AllFields = c.getDeclaredFields();

            for (Field field: AllFields) {
                if (field.getDeclaredAnnotationsByType(MyAutowired.class).length > 0) {
                    Class<?> fieldClass = field.getType();
                    Object fieldObject = getFromMap(fieldClass, fieldClass.getDeclaredConstructor().newInstance());
                    putIntoMap(fieldClass, fieldObject);
                    field.set(object, fieldObject);
                }
            }
        }
    }


    private Object getFromMap(Class<?> clazz, Object defaultValue) {
        return mapsData.getOrDefault(clazz.getSimpleName(), defaultValue);
    }

    private void putIntoMap(Class<?> clazz, Object object) {
        mapsData.put(clazz.getSimpleName(), object);
    }

    public <T> T getBeans(Class<T> clazz) throws BeanNotFoundException {
        T o = (T)getFromMap(clazz, null);
        if (o == null) {
            throw new BeanNotFoundException();
        }
        return o;
    }
}