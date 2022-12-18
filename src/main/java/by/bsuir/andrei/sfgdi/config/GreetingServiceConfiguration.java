package by.bsuir.andrei.sfgdi.config;

import by.bsuir.andrei.sfgdi.services.ConstructorInjectedGreetingService;
import by.bsuir.andrei.sfgdi.services.PropertyInjectedGreetingService;
import by.bsuir.andrei.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//took off the @Stereotype annotations from my own services just for example.
//@Configuration is usually used for third-party components.
@Configuration
public class GreetingServiceConfiguration {

    @Bean
    public PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    public SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Bean
    public ConstructorInjectedGreetingService constructorInjectedGreetingService() {
        return new ConstructorInjectedGreetingService();
    }
}
