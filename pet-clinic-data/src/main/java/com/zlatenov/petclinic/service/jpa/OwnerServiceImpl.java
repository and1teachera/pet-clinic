package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.repository.OwnerRepository;
import com.zlatenov.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Angel Zlatenov
 */
@Service
//@Profile({"default", "jpa"})
public class OwnerServiceImpl extends AbstractCrudOperationsServiceImpl<Owner, OwnerRepository> implements OwnerService {

    public OwnerServiceImpl(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName).orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return repository.findAllByLastNameLike("%" + lastName + "%");
    }
}
