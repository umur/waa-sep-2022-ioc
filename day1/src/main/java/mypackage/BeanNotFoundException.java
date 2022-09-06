package mypackage;

public class BeanNotFoundException extends RuntimeException{
    public BeanNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
