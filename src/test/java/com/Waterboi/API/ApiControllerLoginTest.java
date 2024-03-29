package com.Waterboi.API;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class ApiControllerLoginTest {

    @Autowired
    private MockMvc mockMvc;

    //Test Case 1
    @Test
    public void whenAppuserRegsitered_AppuserCanLogin() throws Exception {
        mockMvc.perform(post("/register")
                .param("username", "newUser")
                .param("password", "password")
                .param("passwordConfirm", "password")
                .with(csrf()));
        mockMvc.perform(post("/login")
                        .param("username", "newUser")
                        .param("password", "password")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));
    }

    //Test
}
