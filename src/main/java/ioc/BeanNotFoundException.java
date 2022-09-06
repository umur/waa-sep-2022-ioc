package ioc;

public class BeanNotFoundException extends Exception {
    public BeanNotFoundException(String msg) {
        super(msg);
    }
}
