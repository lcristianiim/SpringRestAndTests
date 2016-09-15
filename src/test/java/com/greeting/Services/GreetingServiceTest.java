package com.greeting.Services;

import com.greeting.Entities.Greeting;
import com.greeting.Repositories.GreetingRepository;
import com.greeting.Services.GreetingService;
import com.greeting.SpringTutorialRestApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringApplicationConfiguration(classes = SpringTutorialRestApplication.class)
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingRepository greetingRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGreeting() throws Exception {
        Greeting greetingToAdd = new Greeting(1, "Description");
        Greeting addedGreeting = greetingService.addGreeting(greetingToAdd);

        assertEquals(greetingToAdd, addedGreeting);
    }
}