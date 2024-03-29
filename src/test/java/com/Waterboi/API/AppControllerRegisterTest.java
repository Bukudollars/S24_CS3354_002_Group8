package com.Waterboi.API;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerRegisterTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerShouldReturnRegisterPage() throws Exception {
        this.mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    //test case 1
    @Test
    @Transactional
    public void whenRegisterAppuser_theAppuserIsRegistered() throws Exception {

        mockMvc.perform(post("/register")
                .param("username", "newUser")
                .param("password", "password")
                .param("passwordConfirm", "password")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    //Test case 2
    @Test
    @Transactional
    public void whenRegisterAppuser_confirmPasswordInvalid_throwException() throws Exception{
        assertTrue(false);
    }
    //Test case 3
    @Test
    @Transactional
    public void whenRegisterAppuser_confirmPasswordIncorrectLength_throwException() throws Exception{
        assertTrue(false);
    }




    @Test
    @Transactional
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

}
