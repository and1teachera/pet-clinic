package com.zlatenov.petclinic.service.jpa;

import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.repository.VetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
class VetServiceImplTest extends AbstractCrudOperationsServiceImplTest<Vet, VetRepository, VetServiceImpl> {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetServiceImpl vetService;

    @BeforeEach
    void setUp() {
        aClass = Vet.class;
        service = vetService;
        repository = vetRepository;
        super.setUp();
    }
}