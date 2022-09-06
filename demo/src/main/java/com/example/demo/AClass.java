package com.example.demo;

@MyBean
public class AClass {
    @MyAutowired
    BClass bClass;

    @Override
    public String toString() {
        return "AClass{BClass=" + bClass + '}';
    }
}
