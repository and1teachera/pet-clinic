package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.repository.VetRepository;
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
