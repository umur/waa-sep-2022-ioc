package reflection;

@MyBean
public class ClassOne {
    @MyAutowired
    ClassTwo classTwo;


    @Override
    public String toString() {
        return "AClass{" +
                "bClass=" + classTwo +
                '}';
    }
}
