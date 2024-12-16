package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Angel Zlatenov
 */
@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest extends AbstractCrudOperationsServiceImplTest<Owner, OwnerRepository, OwnerServiceImpl> {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        aClass = Owner.class;
        service = ownerService;
        repository = ownerRepository;
        super.setUp();
    }

    @Test
    @DisplayName("Should find by last name")
    void shouldFindByLastName() {
        Owner owner = collection.get(0);
        String lastName = "LastName1";
        owner.setLastName(lastName);
        when(ownerRepository.findByLastName(lastName)).thenReturn(Optional.of(owner));

        Owner ownerServiceByLastName = ownerService.findByLastName(lastName);

        assertNotNull(ownerServiceByLastName);
        assertEquals(owner.getId(), ownerServiceByLastName.getId());
        assertEquals(owner.getLastName(), ownerServiceByLastName.getLastName());
    }
}