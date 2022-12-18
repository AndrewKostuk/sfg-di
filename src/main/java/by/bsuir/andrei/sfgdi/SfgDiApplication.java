package by.bsuir.andrei.sfgdi;

import by.bsuir.andrei.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");
        System.out.println("PRIMARY_________________________");
        System.out.println(controller.sayHello());

        System.out.println("PROPERTY_________________________");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("SETTER___________________________");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("CONSTRUCTOR_______________________");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("I18N_______________________");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("THE BEST PET IS____________________________________");
        PetController petController = (PetController) ctx.getBean("petController");
        System.out.println(petController.whichPetIsTheBest());
    }

}
