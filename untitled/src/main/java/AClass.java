@MyBean
public class AClass {
    @MyAutowired
    public BClass b;

    public void print(){
        System.out.println("printing class A");

    }
    public void display(){
        b.print();
    }
}
