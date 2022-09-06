package edu.miu.lab1.advanced.repository.mysql;

import edu.miu.lab1.advanced.annotation.MyBean;

@MyBean
public class MySQLProductRepository {

    public String getSpecialProductName(String id) {
        return "Special-Product-" + id;
    }
}
