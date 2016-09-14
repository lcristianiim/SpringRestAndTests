package com.greeting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringApplicationConfiguration(classes = SpringTutorialRestApplication.class)
public class GreetingControllerTest {
    @Autowired
    private GreetingService greetingService;

    @Test
    public void get() throws Exception {

    }

    @Test
    public void create() throws Exception {
        Greeting greetingToAdd = greetingService.saveGreeting(new Greeting(1, "Test"));
        Greeting addedGreeting = greetingService.getGreeting(1L);

        assertEquals(greetingToAdd, addedGreeting);
    }

}