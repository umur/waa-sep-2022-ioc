package edu.miu;

import edu.miu.controller.MyController;

public class MyApplication {

    public static void main( String[] args ) {
        try {
            MyController myController = (MyController) MyInjector.getBean(MyController.class);
            System.out.println(myController.getName("1"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
