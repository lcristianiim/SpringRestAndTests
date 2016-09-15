package com.greeting.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greeting.Entities.Greeting;
import com.greeting.Services.GreetingService;
import com.greeting.SpringTutorialRestApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.ws.rs.core.MediaType;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by internship on 14.09.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTutorialRestApplication.class)
public class GreetingControllerTest {

    public MockMvc mockMvc;
    @Autowired
    private WebApplicationContext web;

    protected Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(web)
                .build();
    }

    @MockBean
    private GreetingService greetingService;

    @Test
    public void create() throws Exception {
        given(this.greetingService.getGreeting(1))
                .willReturn(new Greeting(1, "Simple Test"));

        Greeting greeting = new Greeting("Description");

        Gson gson = new Gson();
        this.mockMvc.perform(post("/greetings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(greeting))
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Simple Test"));
    }

}