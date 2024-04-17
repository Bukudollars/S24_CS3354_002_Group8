package com.Waterboi.API;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.Waterboi.API.controller.HydrationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = HydrationController.class)
public class HydrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestValidInput() throws Exception {
        mockMvc.perform(post("hydration/add"))
                .param("drink", "Water")
                .param("amount", "80")
                .andExpect(status().isOk())
                .andExpect(content().string("Water bottle updates"));
    }

    @Test
    public void TestInvalidInput() throws Exception {
        mockMvc.perform(post("hydration/add"))
                .param("drink", "Coke")
                .param("amount", "-5")
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Show error message"));



    }



}
