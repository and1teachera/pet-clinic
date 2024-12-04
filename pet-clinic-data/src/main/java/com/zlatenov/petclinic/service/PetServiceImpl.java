package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.repository.PetRepository;
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
