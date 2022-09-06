package edu.miu.repo;

import edu.miu.MyBean;

@MyBean
public class MyRepository {
    public String getName(String id) {
        return "Name-" + id;
    }
}
