package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Angel Zlatenov
 */

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
