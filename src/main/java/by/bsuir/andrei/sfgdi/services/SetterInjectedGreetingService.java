package by.bsuir.andrei.sfgdi.services;

import org.springframework.stereotype.Service;

public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, world from Setter";
    }
}
