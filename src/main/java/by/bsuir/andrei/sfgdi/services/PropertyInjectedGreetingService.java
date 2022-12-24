package by.bsuir.andrei.sfgdi.services;

public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, world from Property";
    }
}
