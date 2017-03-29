package controllers;

import models.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/addGreeting", method = RequestMethod.POST, headers = "Accept=application/json")
    public Greeting addGreeting(@RequestBody Greeting model) {
        // add new item here
        System.out.print("\"Hello\"");
        return model;
    }
}
