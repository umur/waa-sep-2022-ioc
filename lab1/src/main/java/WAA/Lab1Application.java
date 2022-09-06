package WAA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
        MyInjector inject = new MyInjector();
        inject.searchObjects();

        try{
            inject.getBean(AClass.class);
            inject.getBean(BClass.class);
        } catch (BeanNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    //test
}
