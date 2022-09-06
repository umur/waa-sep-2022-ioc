package com.waa.ioc;

@MyBean // IoC Component marker
public class ClassA {
    private  ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }
}
