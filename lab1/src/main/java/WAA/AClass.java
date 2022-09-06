package WAA;



@MyBean
public class AClass {
    @MyAutowired
    private BClass b;

    AClass(){
        System.out.println("AClass is being instantiated.");
    }
}
