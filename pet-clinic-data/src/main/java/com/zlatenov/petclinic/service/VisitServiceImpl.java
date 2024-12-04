package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Visit;
import com.zlatenov.petclinic.repository.VisitRepository;
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
