package org.example;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class MyInjector {

    MyInjector() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage("org.example")
                .filterInputsBy(new FilterBuilder()
                        .includePackage("org.example")));

        System.out.println(reflections.getTypesAnnotatedWith(MyBean.class));
    }
//    map

//    seach through package

//   find class with annotation
}