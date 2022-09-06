package edu.miu.service;

import edu.miu.MyAutowired;
import edu.miu.MyBean;
import edu.miu.repo.MyRepository;

@MyBean
public class MyService {

    @MyAutowired
    private MyRepository myRepository;

    public String getName(String id) {
        return this.myRepository.getName(id);
    }
}
