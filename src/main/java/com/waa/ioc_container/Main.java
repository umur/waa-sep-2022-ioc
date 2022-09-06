package com.waa.ioc_container;

public class Main {
    public static void main(String[] args) {
        MyInjector myInjector = new MyInjector("com.waa.ioc_container");
        SampleBean sampleBean = myInjector.getBean(SampleBean.class);

    }
}
