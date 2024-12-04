package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Speciality;
import com.zlatenov.petclinic.repository.SpecialityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Angel Zlatenov
 */

@ExtendWith(MockitoExtension.class)
class SpecialityServiceImplTest extends AbstractCrudOperationsServiceImplTest<Speciality, SpecialityRepository, SpecialityServiceImpl> {

    @Mock
    private SpecialityRepository specialityRepository;

    @InjectMocks
    private SpecialityServiceImpl specialityService;

    @BeforeEach
    void setUp() {
        aClass = Speciality.class;
        service = specialityService;
        repository = specialityRepository;
        super.setUp();
    }
}