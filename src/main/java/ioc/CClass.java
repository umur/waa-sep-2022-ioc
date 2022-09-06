package ioc;

@MyBean
public class CClass {
    public CClass() {
        System.out.println("C Class constructor");
    }

    public void call() {
        System.out.println("Inside C Class call");
    }
}
