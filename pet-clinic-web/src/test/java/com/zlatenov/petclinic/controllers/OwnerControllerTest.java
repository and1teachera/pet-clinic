package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = OwnerController.class)
class OwnerControllerTest {

    @MockBean
    private OwnerService ownerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listOwners() throws Exception {
        Set<Owner> owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owners.add(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner2);
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("owners"))
               .andExpect(model().attribute("owners", hasSize(2)))
               .andExpect(view().name("owners/index"));

        verify(ownerService).findAll();
    }

    @Test
    void find() throws Exception {
        mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("notimplemented"));
    }
}