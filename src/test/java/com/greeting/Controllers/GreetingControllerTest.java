package com.greeting.Controllers;

import com.greeting.Entities.Greeting;
import com.greeting.Repositories.GreetingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GreetingControllerTest {
    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void get() throws Exception {

    }

    @Test
    public void create() throws Exception {
        Greeting greetingToAdd = greetingRepository.save(new Greeting(1, "Test"));
        Greeting addedGreeting = greetingRepository.findOne(1L);

        assertEquals(greetingToAdd, addedGreeting);
    }

}