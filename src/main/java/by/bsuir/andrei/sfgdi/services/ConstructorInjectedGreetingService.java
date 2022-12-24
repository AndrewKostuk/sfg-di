package by.bsuir.andrei.sfgdi.services;

public class ConstructorInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, world from Constructor";
    }
}
