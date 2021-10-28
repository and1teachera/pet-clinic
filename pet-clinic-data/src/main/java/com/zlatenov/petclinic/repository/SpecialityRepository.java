package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Angel Zlatenov
 */

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
