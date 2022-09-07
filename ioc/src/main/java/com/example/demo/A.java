package com.example.demo;

@MyBean
public class A {
    @MyAutowired
    B b;

    @Override
    public String toString() {
        return "This is " + b + " inside A class";
    }
}
