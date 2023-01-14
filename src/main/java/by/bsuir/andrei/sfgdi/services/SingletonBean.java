package by.bsuir.andrei.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton Bean!!!!!!!!!!!!!");
    }

    public String getScope() {
        return "I'm a Singleton Bean!!!!!!!!!!!!!";
    }
}
