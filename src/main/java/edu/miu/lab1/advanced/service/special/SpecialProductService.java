package edu.miu.lab1.advanced.service.special;

import edu.miu.lab1.advanced.annotation.MyAutowired;
import edu.miu.lab1.advanced.annotation.MyBean;
import edu.miu.lab1.advanced.repository.mysql.MySQLProductRepository;

@MyBean
public class SpecialProductService {

    @MyAutowired
    private MySQLProductRepository mySQLProductRepository;

    public String getSpecialProductName(String id) {
        return mySQLProductRepository.getSpecialProductName(id);
    }
}
