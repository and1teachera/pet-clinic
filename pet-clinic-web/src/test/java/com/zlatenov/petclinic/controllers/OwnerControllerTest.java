package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
    @DisplayName("Should find owners")
    void shouldFindOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/findOwners"))
               .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    @DisplayName("Should return many owners")
    void shouldReturnManyOwners() throws Exception {
        List<Owner> owners = new ArrayList<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owners.add(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner2);
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(owners);

        mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/ownersList"))
               .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    @DisplayName("Should return one owner")
    void shouldReturnOneOwner() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Collections.singletonList(owner));

        mockMvc.perform(get("/owners"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    @DisplayName("Should return many owners when last name is empty")
    void shouldReturnManyOwnersWhenLastNameIsEmpty() throws Exception {
        List<Owner> owners = new ArrayList<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owners.add(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner2);
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(owners);

        mockMvc.perform(get("/owners")
                .param("lastName",""))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/ownersList"))
               .andExpect(model().attribute("selections", hasSize(2)));;
    }

    @Test
    @DisplayName("Should show owner details")
    void shouldShowOwnerDetails() throws Exception {
        Owner owner = new Owner();
        long id = 1L;
        owner.setId(id);
        when(ownerService.findById(id)).thenReturn(owner);
        mockMvc.perform(get("/owners/1"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("owner"))
               .andExpect(model().attribute("owner", hasProperty("id", is(id))))
               .andExpect(view().name("owners/ownerDetails"));
    }

    @Test
    @DisplayName("Should initialize creation form")
    void shouldInitCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/createOrUpdateOwnerForm"));

        verifyNoInteractions(ownerService);
    }

    @Test
    @DisplayName("Should process creation form")
    void shouldProcessCreationForm() throws Exception {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);

        mockMvc.perform(post("/owners/new"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/1"));

        ArgumentCaptor<Owner> ownerArgumentCaptor = ArgumentCaptor.forClass(Owner.class);
        verify(ownerService).save(ownerArgumentCaptor.capture());
        assertNull(ownerArgumentCaptor.getValue().getId());
    }

    @Test
    @DisplayName("Should initialize update owner form")
    void shouldInitUpdateOwnerForm() throws Exception {
        long id = 1L;
        Owner owner = Owner.builder().id(id).build();
        when(ownerService.findById(id)).thenReturn(owner);

        mockMvc.perform(get("/owners/1/edit"))
               .andExpect(status().isOk())
               .andExpect(view().name("owners/createOrUpdateOwnerForm"))
               .andExpect(model().attributeExists("owner"));
    }

    @Test
    @DisplayName("Should process update owner form")
    void shouldProcessUpdateOwnerForm() throws Exception {
        Owner owner = new Owner();
        long id = 1L;
        owner.setId(id);
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);

        mockMvc.perform(post("/owners/1/edit"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/1"));

        verify(ownerService).save(ArgumentMatchers.any());
    }
}