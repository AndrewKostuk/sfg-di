package by.bsuir.andrei.sfgdi.config;

import by.bsuir.andrei.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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

    @Primary
    @Bean
    public PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Profile("EN")
    @Bean("i18nService")
    public I18nEnglishGreetingService i18nEnglishGreetingService() {
        return new I18nEnglishGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    public I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }
}
