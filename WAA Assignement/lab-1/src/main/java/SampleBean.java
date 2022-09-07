package lab1.main;

import lab1.main.annotations.MyAutowired;
import lab1.main.annotations.MyBean;
import lab1.main.exception.BeanNotFoundException;

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
        MyInjector myInjector=new MyInjector();
        myInjector.scanForBean();
        System.out.println("----");
        System.out.println(myInjector.getBean(SampleBean.class));
    }
}
