package day1;

@MyBean
public class FirstClass {
    private String name;
    @MyAutoWired
    SecondClass secondClass;

    public boolean isSet(){
        return secondClass != null;
    }
}
