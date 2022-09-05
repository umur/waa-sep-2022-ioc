
@MyBean
public class AClass {


    @MyAutowired
   public BClass b;

    public void print(){
        System.out.println("Print Class A");
    }

    public  void display(){
        b.print();
    }


}
