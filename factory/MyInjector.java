package factory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyInjector {

    private static final Map<BeanEntry, Object> context = new HashMap<>();
    private final String basePackage;

    public MyInjector() {
        basePackage= this.getClass().getPackageName();
    }
    public MyInjector(String basePackage) {
        this.basePackage = basePackage;
    }

    public void scan(){
        Set<Class> classSet = findAllClassesUsingClassLoader(basePackage);
        for(Class cls: classSet){
            Constructor constructor = cls.getConstructors()[0];
            try {
                constructor.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Class getCls(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getCls(line, packageName))
                .collect(Collectors.toSet());
    }

    public Object getBean(String name){
        return null;
    }

    public <T> T getBean(Class<T> cls){
        return null;
    }

    public <T> T getBean(String name, Class<T> cls){
        return null;
    }

    public String getBasePackage(){
        return this.basePackage;
    }

}
