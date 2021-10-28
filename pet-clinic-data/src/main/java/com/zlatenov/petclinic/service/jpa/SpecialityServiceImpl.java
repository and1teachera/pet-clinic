package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Speciality;
import com.zlatenov.petclinic.repository.SpecialityRepository;
import com.zlatenov.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
@Profile({"default", "jpa"})
public class SpecialityServiceImpl extends AbstractCrudOperationsServiceImpl<Speciality, SpecialityRepository> implements SpecialityService {
    public SpecialityServiceImpl(SpecialityRepository repository) {
        super(repository);
    }
}
