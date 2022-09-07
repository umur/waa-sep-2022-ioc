package edu.miu.Lab1.exception;

public class BeanNotFoundException extends Exception{
    public BeanNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
