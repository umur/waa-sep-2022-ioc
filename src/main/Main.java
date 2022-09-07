package main;

import main.sample.A;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class Main {
    //scan for all @MyBean objects
    //create an instance for every @MyAutowired field
    //stored created classes in a map
    //create a method to retrieve the object found in the map by class name
    public static void main(String[] args) {
        MyInjector myInjector = new MyInjector();
        A aClass = myInjector.getBean(A.class);
        System.out.println(aClass.getbClass());
    }
}
