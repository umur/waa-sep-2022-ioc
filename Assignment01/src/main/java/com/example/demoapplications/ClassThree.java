package com.example.demoapplications;
@MyBean
public class ClassThree {
    @MyAutowired
    private ClassTwo classTwo;

    @Override
    public String toString() {
        return classTwo.testFunction() ;
    }
}
