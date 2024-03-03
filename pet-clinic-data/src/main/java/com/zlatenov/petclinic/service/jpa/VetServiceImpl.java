package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.repository.VetRepository;
import com.zlatenov.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


/**
 * @author Angel Zlatenov
 */
@Service
public class VetServiceImpl extends AbstractCrudOperationsServiceImpl<Vet, VetRepository> implements VetService {
    public VetServiceImpl(VetRepository repository) {
        super(repository);
    }
}
