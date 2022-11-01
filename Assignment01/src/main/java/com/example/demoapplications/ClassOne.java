package com.example.demoapplications;
@MyBean
public class ClassOne {
    @MyAutowired
    private ClassTwo classB;

    @Override
    public String toString() {
        return "ClassOne" ;
    }
}
