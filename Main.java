import factory.MyInjector;

public class Main {

    public static void main(String[] args) {
        MyInjector injector = new MyInjector("beans");

        System.out.println(injector.getBasePackage());
    }
}
