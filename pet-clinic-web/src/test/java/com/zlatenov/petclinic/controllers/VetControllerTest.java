package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.service.VetService;
import org.junit.jupiter.api.DisplayName;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = VetController.class)
class VetControllerTest {

    @MockBean
    private VetService vetService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should list all vets")
    void shouldListVets() throws Exception {
        Set<Vet> vets = new HashSet<>();
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vets.add(vet1);
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vets.add(vet2);
        when(vetService.findAll()).thenReturn(vets);

        mockMvc.perform(get("/vets"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("vets"))
               .andExpect(model().attribute("vets", hasSize(2)))
               .andExpect(view().name("vets/index"));

        verify(vetService).findAll();
    }

    @Test
    @DisplayName("Should list vets by index path")
    void shouldListVetsByIndexPath() throws Exception {
        Set<Vet> vets = new HashSet<>();
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vets.add(vet1);
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vets.add(vet2);
        when(vetService.findAll()).thenReturn(vets);

        mockMvc.perform(get("/vets/index"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("vets"))
                .andExpect(model().attribute("vets", hasSize(2)))
                .andExpect(view().name("vets/index"));

        verify(vetService).findAll();
    }

    @Test
    @DisplayName("Should list vets by index.html path")
    void shouldListVetsByIndexHtmlPath() throws Exception {
        Set<Vet> vets = new HashSet<>();
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vets.add(vet1);
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vets.add(vet2);
        when(vetService.findAll()).thenReturn(vets);

        mockMvc.perform(get("/vets/index.html"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("vets"))
                .andExpect(model().attribute("vets", hasSize(2)))
                .andExpect(view().name("vets/index"));

        verify(vetService).findAll();
    }

    @Test
    @DisplayName("Should list vets by .html path")
    void shouldListVetsByHtmlPath() throws Exception {
        Set<Vet> vets = new HashSet<>();
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vets.add(vet1);
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vets.add(vet2);
        when(vetService.findAll()).thenReturn(vets);

        mockMvc.perform(get("/vets/.html"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("vets"))
                .andExpect(model().attribute("vets", hasSize(2)))
                .andExpect(view().name("vets/index"));

        verify(vetService).findAll();
    }

    @Test
    @DisplayName("Should list vets by root path")
    void shouldListVetsByRootPath() throws Exception {
        Set<Vet> vets = new HashSet<>();
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vets.add(vet1);
        Vet vet2 = new Vet();
        vet2.setId(2L);
        vets.add(vet2);
        when(vetService.findAll()).thenReturn(vets);

        mockMvc.perform(get("/vets/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("vets"))
                .andExpect(model().attribute("vets", hasSize(2)))
                .andExpect(view().name("vets/index"));

        verify(vetService).findAll();
    }
}