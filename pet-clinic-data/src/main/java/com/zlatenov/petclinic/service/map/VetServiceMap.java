package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.exceptions.SavingNullObjectsException;
import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.service.SpecialityService;
import com.zlatenov.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Angel Zlatenov
 */

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

    private final SpecialityService specialityService;

    @Autowired
    public VetServiceMap(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(final Vet vet) {
        if(Optional.ofNullable(vet)
                .orElseThrow(SavingNullObjectsException::new)
                .getSpecialities().isEmpty()){
            throw new SavingNullObjectsException("We cannot save a Vet without specialty");
        }

        vet.setSpecialities(new HashSet<>(specialityService.saveAll(vet.getSpecialities().stream()
                .filter(speciality -> speciality.getId() == null)
                .collect(Collectors.toSet()))));

        return super.save(vet);
    }
}
