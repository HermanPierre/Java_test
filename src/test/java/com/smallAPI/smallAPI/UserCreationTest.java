package com.smallAPI.smallAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserCreationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void createUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/users/createUser").accept(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Jean\", \"lastName\": \"Smith\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Jean")))
                .andExpect(content().string(containsString("Smith")));
    }
}
