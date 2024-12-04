package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.repository.PetTypeRepository;
import com.zlatenov.petclinic.service.PetTypeService;
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
