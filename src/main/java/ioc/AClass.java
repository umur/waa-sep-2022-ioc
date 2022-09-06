package ioc;

@MyBean
public class AClass {
    @MyAutowired
    private BClass bClass;

    public AClass() {
        System.out.println("A Class constructor");
    }

    public void show() {
        System.out.println("Inside A Class show function.");
    }

    public void call() {
        System.out.println("Inside A Class call function. Going to call B Class function");
        bClass.call();
    }
}
