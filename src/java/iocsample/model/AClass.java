package iocsample.model;

import iocsample.MyAutowired;
import iocsample.MyBean;

@MyBean
public class AClass {
    @MyAutowired
    private BClass b;
}
