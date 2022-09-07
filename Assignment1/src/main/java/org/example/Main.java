package org.example;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, NoBeanFoundException {
        MyInjector injector = new MyInjector();

        injector.saveBeans();
        injector.Injection();

        SecondClass secondClass = (SecondClass) injector.getBean(SecondClass.class);
        secondClass.print();
    }
}