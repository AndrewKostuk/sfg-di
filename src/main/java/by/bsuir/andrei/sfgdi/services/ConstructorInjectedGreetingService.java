package by.bsuir.andrei.sfgdi.services;

import org.springframework.stereotype.Service;

public class ConstructorInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello, world from Constructor";
    }
}
