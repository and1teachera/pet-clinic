package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Visit;
import com.zlatenov.petclinic.repository.VisitRepository;
import com.zlatenov.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
public class VisitServiceImpl extends AbstractCrudOperationsServiceImpl<Visit, VisitRepository> implements VisitService {
    public VisitServiceImpl(VisitRepository repository) {
        super(repository);
    }
}
