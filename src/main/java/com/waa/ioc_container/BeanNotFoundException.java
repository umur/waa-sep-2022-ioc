package com.waa.ioc_container;

public class BeanNotFoundException extends RuntimeException{
    public BeanNotFoundException(String message) {
        super(message);
    }
}
