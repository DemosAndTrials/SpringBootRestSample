package controllers;

import models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.GreetingService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/findbyid")
    public Greeting findById(@RequestParam("id") long id){
        Greeting result = greetingService.findById(id);
        return result;
    }

    @RequestMapping(value = "/addgreeting", method = RequestMethod.POST, headers = "Accept=application/json")
    public Greeting addGreeting(@RequestBody Greeting model) {
        // add new item here
        greetingService.save(model);
        System.out.print("\"Hello\"");
        return model;
    }

    @RequestMapping(value = "/addgreetings", method = RequestMethod.POST, headers = "Accept=application/json")
    public Iterable<Greeting> addGreeting(@RequestBody List<Greeting> model) {
        // add new item here
        greetingService.save(model);
        System.out.print("\"Hello\"");
        return model;
    }

    @RequestMapping("/findall")
    public Iterable<Greeting> findAll(){
        Iterable<Greeting> result = greetingService.findAll();
        return result;
    }

    @RequestMapping("/findalllike")
    public Iterable<Greeting> findAllLike(@RequestParam("like") String like){
        Iterable<Greeting> result = greetingService.findByContentLike(like);
        return result;
    }

    @RequestMapping("/findbyidgreater")
    public Iterable<Greeting> findAllLike(@RequestParam("id") long id){
        Iterable<Greeting> result = greetingService.findByIdGreater(id);
        return result;
    }
}
