package mypackage;
@MyBean
public class ClassB {
    @MyAutowired
    ClassA classA;

    public void call(){
        classA.print();
    }

}
