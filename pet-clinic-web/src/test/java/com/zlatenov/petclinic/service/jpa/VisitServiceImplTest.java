package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Visit;
import com.zlatenov.petclinic.repository.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Angel Zlatenov
 */

@ExtendWith(MockitoExtension.class)
class VisitServiceImplTest extends AbstractCrudOperationsServiceImplTest<Visit, VisitRepository, VisitServiceImpl> {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitServiceImpl visitService;

    @BeforeEach
    void setUp() {
        aClass = Visit.class;
        service = visitService;
        repository = visitRepository;
        super.setUp();
    }
}