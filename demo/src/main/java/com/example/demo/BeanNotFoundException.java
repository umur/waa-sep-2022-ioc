package com.example.demo;

public class BeanNotFoundException extends Exception {
    public BeanNotFoundException(){
        super("BeanNotFoundException exception, no such kind of bean");
    }
}
