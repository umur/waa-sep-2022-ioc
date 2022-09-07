package org.example;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class MyInjector {
    HashMap<Class, Object> IocContainer =new HashMap<>();
       public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }
   public void saveBeans() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<Class> classes=findAllClassesUsingReflectionsLibrary("org.example");
        for(Class c: classes){
            if(c.isAnnotationPresent(MyBean.class)){
              IocContainer.put(c,c.getDeclaredConstructor().newInstance());
            }
        }
        }


    public Object Injection() throws IllegalAccessException {
        Set<Class> classes = findAllClassesUsingReflectionsLibrary("org.example");
        for(Class c: classes){
            for(Field f: c.getDeclaredFields()){
                if(f.isAnnotationPresent(MyAutowired.class)){
                    if (IocContainer.containsKey(f.getType())) {
                        f.setAccessible(true);
                        f.set(IocContainer.get(f.getDeclaringClass()), IocContainer.get(f.getType()));
                    }
                }
            }
        }
        return null;
    }
    public Object getBean(Class clazz)throws NoBeanFoundException{
           if(IocContainer.containsKey(clazz)){
               return IocContainer.get(clazz);
           }
           else {
               throw new NoBeanFoundException();
           }
       }







}
