package iocsample;

import iocsample.model.BClass;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyInjector.run(Main.class);
        BClass b = (BClass) MyInjector.getBean(BClass.class);
        System.out.println(b.getCClass());
    }
}
