package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
