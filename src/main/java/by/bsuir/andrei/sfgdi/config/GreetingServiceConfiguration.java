package by.bsuir.andrei.sfgdi.config;

import by.bsuir.andrei.sfgdi.datasource.FakeDataSource;
import by.bsuir.andrei.sfgdi.repositories.EnglishGreetingRepository;
import by.bsuir.andrei.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import by.bsuir.andrei.sfgdi.services.*;
import com.bsuir.andrei.sfgdi.pets.PetService;
import com.bsuir.andrei.sfgdi.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

//took off the @Stereotype annotations from my own services just for example.
//@Configuration is usually used for third-party components.
@Configuration
public class GreetingServiceConfiguration {

    @Bean
    public FakeDataSource fakeDataSource(AndreiConfiguration andreiConfiguration) {
        return new FakeDataSource(
                andreiConfiguration.getUsername(),
                andreiConfiguration.getPassword(),
                andreiConfiguration.getJdbcurl()
        );
    }

    @Bean
    public PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
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

    @Bean
    public EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    public I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    public I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }

    @Bean
    public PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    public PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    public PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }
}
