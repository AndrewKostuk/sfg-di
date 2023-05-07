package by.bsuir.andrei.sfgdi;

import by.bsuir.andrei.sfgdi.config.AndreiConfiguration;
import by.bsuir.andrei.sfgdi.config.AndreiConstructorConfiguration;
import by.bsuir.andrei.sfgdi.controllers.*;
import by.bsuir.andrei.sfgdi.datasource.FakeDataSource;
import by.bsuir.andrei.sfgdi.services.PrototypeBean;
import by.bsuir.andrei.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-config.xml")
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

        System.out.println("\n\n---------------Spring Bean Scope-------------------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getScope());

        System.out.println("\n--------PROTOTYPE------------");
        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getScope());

        System.out.println("\n--------FAKE DATA SOURCE------------");
        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

        System.out.println("\n--------PROPERTIES BINDING------------");
        AndreiConfiguration andreiConfiguration = ctx.getBean(AndreiConfiguration.class);
        System.out.println(andreiConfiguration.getUsername());
        System.out.println(andreiConfiguration.getPassword());
        System.out.println(andreiConfiguration.getJdbcurl());

        System.out.println("\n--------CONSTRUCTOR PROPERTIES BINDING------------");
        AndreiConstructorConfiguration andreiConstructorConfiguration = ctx.getBean(AndreiConstructorConfiguration.class);
        System.out.println(andreiConstructorConfiguration.getUsername());
        System.out.println(andreiConstructorConfiguration.getPassword());
        System.out.println(andreiConstructorConfiguration.getJdbcurl());
    }
}
