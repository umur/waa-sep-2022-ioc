package labOne.exception;

public class BeanNotFoundException extends Exception{
    public BeanNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
