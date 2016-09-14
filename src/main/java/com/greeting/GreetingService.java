package com.greeting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by internship on 14.09.2016.
 */
@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting getGreeting (long id) {
        return greetingRepository.findOne(id);
    }

    public Greeting saveGreeting (Greeting greeting) {
        return greetingRepository.save(greeting);
    }
}
