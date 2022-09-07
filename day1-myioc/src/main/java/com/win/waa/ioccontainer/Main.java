package com.win.waa.ioccontainer;

public class Main {
    public static void main(String[] args) {
        MyInjector.startApplication(Main.class);

        BankingService bankService = MyInjector.getService(BankingService.class);
        bankService.deposit(3000);


    }
}
