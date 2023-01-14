package by.bsuir.andrei.sfgdi.services;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Creating a Prototype Bean!!!!!!!!!!!!!");
    }

    public String getScope() {
        return "I'm a Prototype Bean!!!!!!!!!!!!!";
    }
}
