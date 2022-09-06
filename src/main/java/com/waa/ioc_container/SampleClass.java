package com.waa.ioc_container;

public class SampleClass {
    @MyAutowired
    SampleBean sampleBean;

    public SampleClass() {
        System.out.println("sample class has been created.");
    }
}
