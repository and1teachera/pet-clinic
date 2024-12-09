package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetService;
import com.zlatenov.petclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

    @MockBean
    private PetTypeService petTypeService;

    @Autowired
    private MockMvc mockMvc;

    private Owner owner;
    private Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);

        PetType dog = new PetType();
        dog.setId(1L);
        dog.setName("Dog");

        petTypes = new HashSet<>();
        petTypes.add(dog);

        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
    }

    @Test
    @DisplayName("Should initialize creation form")
    void shouldInitCreationForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    @DisplayName("Should initialize update form")
    void shouldInitUpdateForm() throws Exception {
        Pet pet = new Pet();
        pet.setId(2L);
        when(petService.findById(anyLong())).thenReturn(pet);

        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }
}