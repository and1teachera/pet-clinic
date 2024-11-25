package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = PetController.class)
public class PetControllerTest {

    @MockBean
    private PetService petService;

    @MockBean
    private OwnerService ownerService;

    @Autowired
    private MockMvc mockMvc;





}
