package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.exceptions.SavingNullObjectsException;
import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.service.OwnerService;
import com.zlatenov.petclinic.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */
@AllArgsConstructor
@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    private final PetService petService;

    @Override
    public Owner findByLastName(final String lastName) {
        return map.values()
                .stream()
                .filter(owner -> StringUtils.endsWithIgnoreCase(owner.getLastName(), lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(final Owner owner) {
        final Set<Pet> pets = Optional.ofNullable(owner)
                .orElseThrow(SavingNullObjectsException::new)
                .getPets();

        if(pets.isEmpty()) {
            throw new SavingNullObjectsException("We cannot save owners without pets");
        }

        if(pets.stream()
                .anyMatch(pet -> Objects.isNull(pet.getPetType()))) {
            throw new SavingNullObjectsException("We cannot save owners which pets doesnt have a type");
        }

        owner.setPets(new HashSet<>(petService.saveAll(pets)));

        return super.save(owner);
    }
}
