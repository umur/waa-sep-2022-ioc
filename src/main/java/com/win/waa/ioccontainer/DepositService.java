package com.win.waa.ioccontainer;

@MyBean
public class DepositService {

    public void deposit(double amount) {
        System.out.println("Depositing amount " + amount);
    }
}
