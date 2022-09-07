package labOne;

import labOne.annotations.MyAutowired;
import labOne.annotations.MyBean;

@MyBean

public class Test {
    @MyAutowired
    private String name;
    @MyAutowired
    private String lname;
    private String email;

    public static void main(String[] args) throws Exception {
        System.out.println("Lllll");
        MyInjector myInjector=new MyInjector();
        myInjector.searchBean();
        System.out.println("aaaa");
        System.out.println(myInjector.getBean(Test.class));
    }
}
