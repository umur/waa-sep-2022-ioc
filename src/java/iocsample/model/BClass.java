package iocsample.model;

import iocsample.MyAutowired;

public class BClass {
    @MyAutowired
    private CClass c;
    public CClass getCClass() { return this.c;}
}
