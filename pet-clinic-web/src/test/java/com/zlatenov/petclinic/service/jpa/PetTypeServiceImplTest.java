package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.repository.PetTypeRepository;
import com.zlatenov.petclinic.service.PetTypeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Angel Zlatenov
 */

@ExtendWith(MockitoExtension.class)
class PetTypeServiceImplTest extends AbstractCrudOperationsServiceImplTest<PetType, PetTypeRepository, PetTypeServiceImpl> {

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private PetTypeServiceImpl petTypeService;

    @BeforeEach
    void setUp() {
        aClass = PetType.class;
        service = petTypeService;
        repository = petTypeRepository;
        super.setUp();
    }
}