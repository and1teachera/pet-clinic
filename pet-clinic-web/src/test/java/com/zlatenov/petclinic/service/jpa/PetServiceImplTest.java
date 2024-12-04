package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
class PetServiceImplTest extends AbstractCrudOperationsServiceImplTest<Pet, PetRepository, PetServiceImpl> {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @BeforeEach
    void setUp() {
        aClass = Pet.class;
        service = petService;
        repository = petRepository;
        super.setUp();
    }
}