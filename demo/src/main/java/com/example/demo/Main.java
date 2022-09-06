package com.example.demo;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, BeanNotFoundException {
        MyInjector myInjector = new MyInjector();
        myInjector.scanBeans();
        myInjector.injectFields();

        AClass aClass = (AClass) myInjector.getBean(AClass.class);
        System.out.println(aClass);

        // BeanNotFoundException exception, no such kind of bean
        //CClass cClass = (CClass) myInjector.getBean(CClass.class);
    }
}
