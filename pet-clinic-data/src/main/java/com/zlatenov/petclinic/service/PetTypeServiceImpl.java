package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.repository.PetTypeRepository;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
public class PetTypeServiceImpl extends AbstractCrudOperationsServiceImpl<PetType, PetTypeRepository> implements PetTypeService {
    public PetTypeServiceImpl(PetTypeRepository repository) {
        super(repository);
    }
}
