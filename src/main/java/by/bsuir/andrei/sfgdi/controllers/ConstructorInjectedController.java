package by.bsuir.andrei.sfgdi.controllers;

import by.bsuir.andrei.sfgdi.services.GreetingService;
import by.bsuir.andrei.sfgdi.services.ConstructorInjectedGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    @Autowired
    public ConstructorInjectedController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public ConstructorInjectedController() {
        this.greetingService = new ConstructorInjectedGreetingService();
    }

    public ConstructorInjectedController(GreetingService greetingService, String hello) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
