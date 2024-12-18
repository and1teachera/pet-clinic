package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Speciality;
import com.zlatenov.petclinic.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
public class SpecialityServiceImpl extends AbstractCrudOperationsServiceImpl<Speciality, SpecialityRepository> implements SpecialityService {
    public SpecialityServiceImpl(SpecialityRepository repository) {
        super(repository);
    }
}
