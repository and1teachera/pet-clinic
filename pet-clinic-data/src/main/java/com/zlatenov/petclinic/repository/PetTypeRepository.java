package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
