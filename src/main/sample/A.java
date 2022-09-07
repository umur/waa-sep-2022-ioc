package main.sample;

import main.annotation.MyAutowired;
import main.annotation.MyBean;

@MyBean
public class A {
    @MyAutowired
    private B bClass;

    public B getbClass() {
        return bClass;
    }
}
