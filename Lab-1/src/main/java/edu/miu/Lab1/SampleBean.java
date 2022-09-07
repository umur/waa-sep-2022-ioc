package edu.miu.Lab1;

import edu.miu.Lab1.annotations.MyAutowired;
import edu.miu.Lab1.annotations.MyBean;
import edu.miu.Lab1.exception.BeanNotFoundException;

import java.lang.reflect.InvocationTargetException;

@MyBean
public class SampleBean {
    @MyAutowired
    private String name;
    @MyAutowired
    private String kal;
    private String nal;

    public static void main(String[] args) throws Exception {
        System.out.println("Last");
        edu.miu.Lab1.MyInjector myInjector=new edu.miu.Lab1.MyInjector();
        myInjector.scanForBean();
        System.out.println("----");
        System.out.println(myInjector.getBean(SampleBean.class));
    }
}
