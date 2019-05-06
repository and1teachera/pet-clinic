package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.exceptions.SavingNullObjectsException;
import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetService;
import com.zlatenov.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Angel Zlatenov
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerServiceMap(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return map.values()
                .stream()
                .filter(owner -> Objects.equals(owner.getFirstName(), lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(final Owner owner) {
        Set<Pet> pets = Optional.ofNullable(owner)
                .stream()
                .flatMap(owner1 -> owner1.getPets().stream())
                .collect(Collectors.toSet());

        if(pets.stream()
                .anyMatch(pet -> Objects.isNull(pet.getPetType()))) {
            throw new SavingNullObjectsException("We cannot save owners which pets doesnt have a type");
        }

        pets = new HashSet<>(petService.saveAll(pets));
        petTypeService.saveAll(pets.stream()
                                       .map(Pet::getPetType)
                                       .collect(Collectors.toSet()));

        return super.save(owner);
    }
}
