package lab1.main.exception;

public class BeanNotFoundException extends Exception{
    public BeanNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
