import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//my id 614686
//Abubakr Abdullaev
//my partner's id 614250
//Narangua Ganbaatar
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws NotFoundBeanException {
        SpringApplication.run(Main.class, args);
        MyInjector i = new MyInjector();
        AClass a = (AClass)i.getBean(AClass.class);
        a.print();
        a.display();
    }
}
