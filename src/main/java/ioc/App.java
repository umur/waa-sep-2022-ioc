package ioc;

public class App {
    public static void main(String[] args) throws BeanNotFoundException {
        MyInjector myInjector = new MyInjector();
        AClass aClass = (AClass) myInjector.getBean(AClass.class);
        aClass.show();
        aClass.call();
    }
}
