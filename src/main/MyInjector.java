package main;

import main.annotation.MyAutowired;
import main.annotation.MyBean;
import main.exception.BeanNotFoundException;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.Scanners;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyInjector {

    private Map<Class<?>, Object> beans = new HashMap<>();
    private Reflections reflections;

    public MyInjector(){
        initReflection();
        initMyBeans();
        injectBeans();
    }

    public <T> T getBean(Class<T> bean){
        try{
            Object foundBean = beans.get(bean);
            return bean.cast(foundBean);
        }catch (Exception e){
            throw new BeanNotFoundException();
        }
    }

    private void initReflection(){
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                .forPackage("main")
                .setScanners(Scanners.TypesAnnotated, Scanners.FieldsAnnotated)
                .filterInputsBy(new FilterBuilder().excludePackage("main.annotation"));
        reflections = new Reflections(configurationBuilder);
        reflections.getAllTypes().forEach(System.out::println);
    }

    private void initMyBeans(){
        Set<Class<?>> beansSet = getBeans();
        beansSet.forEach((bean) -> {
            try {
                Object object = bean.getConstructor().newInstance();
                beans.put(bean, object);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void injectBeans(){
        Set<Field> autoWiredFieldsSet = getAutowiredFields();
        autoWiredFieldsSet.forEach((field) ->{
            field.setAccessible(true);
            Object ownerClass = beans.get(field.getDeclaringClass());
            Object injectedClass = beans.get(field.getType());
            try {
                field.set(ownerClass, injectedClass);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private Set<Class<?>> getBeans() {
        return reflections.getTypesAnnotatedWith(MyBean.class);
    }

    private Set<Field> getAutowiredFields() {
        return reflections.getFieldsAnnotatedWith(MyAutowired.class);
    }

}
