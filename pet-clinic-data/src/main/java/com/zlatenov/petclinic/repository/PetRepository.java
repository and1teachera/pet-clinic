package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface PetRepository extends CrudRepository<Pet, Long> {
}
