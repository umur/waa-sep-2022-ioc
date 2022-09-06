package day1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MyInjector myInjector = new MyInjector();

        FirstClass firstClass = myInjector.getBeans(FirstClass.class);
        System.out.println("First name is set? => "+ firstClass.isSet());

    }
}
