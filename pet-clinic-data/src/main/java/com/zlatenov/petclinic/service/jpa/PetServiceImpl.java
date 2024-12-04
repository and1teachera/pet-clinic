package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.repository.PetRepository;
import com.zlatenov.petclinic.service.PetService;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
public class PetServiceImpl extends AbstractCrudOperationsServiceImpl<Pet, PetRepository> implements PetService {
    public PetServiceImpl(PetRepository repository) {
        super(repository);
    }
}
