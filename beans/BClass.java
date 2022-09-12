package beans;

import annotations.MyAutowired;
import annotations.MyBean;

@MyBean
public class BClass {

    @MyAutowired
    private AClass aClass;
}
