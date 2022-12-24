package by.bsuir.andrei.sfgdi.services;

public class SetterInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, world from Setter";
    }
}
