package waaLab;

import waaClass.Bclass;

public class Main {
	public static void main(String[] args) throws Exception {
        MyInjector myInjector = new MyInjector();
        myInjector.scanForBean();
        System.out.println(myInjector.getBean(Bclass.class));
    }

}
