package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetService;
import com.zlatenov.petclinic.service.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Collection;

@Controller
@AllArgsConstructor
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        pet.setOwner(owner);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet editedPet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            editedPet.setOwner(owner);
            model.addAttribute("pet", editedPet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            Pet pet = (Pet) model.getAttribute("pet");
            pet.setPetType(editedPet.getPetType());
            pet.setBirthDate(editedPet.getBirthDate());
            pet.setName(editedPet.getName());
            pet.setOwner(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}