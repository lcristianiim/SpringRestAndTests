package com.greeting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    protected Gson gson;

    @Autowired
    private WebApplicationContext web;

    @MockBean
    private GreetingService greetingService;

    @Before
    public void setUp() {
        gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(web)
                .build();
    }

    @Test
    public void create() throws Exception {
        given(this.greetingService.getGreeting(1))
                .willReturn(new Greeting(1, "Simple Test"));

        Greeting greeting = new Greeting("Description");

        this.mockMvc.perform(post("/greetings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(greeting))
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Simple Test"));
    }

}