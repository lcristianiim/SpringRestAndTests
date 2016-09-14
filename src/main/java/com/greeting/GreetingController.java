package com.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable(value="id") @NotNull Long id) {
        Greeting greeting = greetingService.getGreeting(id);
        if (greeting != null){
            return greeting;
        }
        return new Greeting(0l, "No greeting");
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Greeting create(@RequestBody Greeting greeting) {
        return greetingService.addGreeting(greeting);
    }
}