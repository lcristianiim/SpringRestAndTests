package com.greeting.Services;

import com.greeting.Entities.Greeting;
import com.greeting.Repositories.GreetingRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by internship on 14.09.2016.
 */
@Service
@Setter
@Getter
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingService() {}

    public Greeting getGreeting(long id) {
        return greetingRepository.findOne(id);
    }

    public Greeting addGreeting(Greeting greeting) {
        Greeting addedGreeting = greetingRepository.save(greeting);
        return addedGreeting;
    }
}
