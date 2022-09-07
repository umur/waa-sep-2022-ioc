package com.example.demo;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws BeanNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        MyInjector myInjector = new MyInjector();
        myInjector.searchBeans();
        myInjector.fieldInjection();

        A a = (A) myInjector.getBeans(A.class);
        System.out.println(a);

    }
}
