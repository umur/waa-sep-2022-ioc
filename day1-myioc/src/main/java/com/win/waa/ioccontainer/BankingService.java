package com.win.waa.ioccontainer;

@MyBean
public class BankingService {
    @MyAutowired
    private DepositService depositService;

    public void deposit(double amount) {
        depositService.deposit(amount);
    }
}
