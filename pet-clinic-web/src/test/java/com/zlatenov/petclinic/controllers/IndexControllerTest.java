package com.zlatenov.petclinic.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = IndexController.class)
@ActiveProfiles("test")
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index() throws Exception {
        mockMvc.perform(get("/index.html"))
               .andExpect(status().isOk())
               .andExpect(view().name("index"));
    }

    @Test
    void oups() throws Exception {
        mockMvc.perform(get("/oups"))
               .andExpect(status().isOk())
               .andExpect(view().name("notimplemented"));
    }
}