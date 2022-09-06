package exceptions;

public class BeanNotFoundException extends Exception{
    public BeanNotFoundException() {}

    public BeanNotFoundException(String message) {
        super(message);
    }
}
