package org.example;
@MyBean
public class SecondClass {
    @MyAutowired
    FirstClass firstClass;

    public SecondClass(){}
    public void print(){
        firstClass.print();
    }

}
