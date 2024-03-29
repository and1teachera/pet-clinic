package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Angel Zlatenov
 */

public interface PetRepository extends JpaRepository<Pet, Long> {
}
