package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, BeanNotFoundException {

        MyInjector myInjector = new MyInjector();
        myInjector.scan();
        myInjector.injectAnnotatedFields();

        ClassOne firstClass = (ClassOne) myInjector.getBean(ClassOne.class);

        System.out.println(firstClass);

        NoBean noBean = (NoBean) myInjector.getBean(NoBean.class);



    }
}
