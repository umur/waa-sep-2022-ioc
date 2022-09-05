public class Main {

    public static void main(String[] args) throws Exception, BeanNotFoundException {
        MyInjector injector = new MyInjector();
        PersonController person = (PersonController) injector.getBeans(PersonController.class);
        AddressController address = (AddressController) injector.getBeans(AddressController.class);

        System.out.println(person);
        System.out.println(address);
    }

}
