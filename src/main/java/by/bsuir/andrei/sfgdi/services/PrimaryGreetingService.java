package by.bsuir.andrei.sfgdi.services;

public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello, world from Primary";
    }
}
