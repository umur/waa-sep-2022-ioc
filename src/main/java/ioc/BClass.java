package ioc;

@MyBean
public class BClass {
    @MyAutowired
    private CClass cClass;

    public BClass() {
        System.out.println("B Class constructor");
    }

    public void call() {
        System.out.println("Inside B Class call, going to call C Class");
        cClass.call();
    }
}
