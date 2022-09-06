package edu.miu.controller;

import edu.miu.MyAutowired;
import edu.miu.MyBean;
import edu.miu.service.MyService;

@MyBean
public class MyController {

    @MyAutowired
    private MyService myService;

    public String getName(String id) {
        return myService.getName(id);
    }

}
