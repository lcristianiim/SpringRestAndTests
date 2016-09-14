package com.greeting.Controllers;

import com.greeting.Entities.Greeting;
import com.greeting.Repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Greeting get(@PathVariable(value="id") @NotNull Long id) {
        Greeting greeting = greetingRepository.findOne(id);
        if (greeting != null){
            return greeting;
        }
        return new Greeting(0, "No greeting");
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Greeting create(@RequestBody Greeting greeting) {

        return greetingRepository.save(greeting);
    }
}