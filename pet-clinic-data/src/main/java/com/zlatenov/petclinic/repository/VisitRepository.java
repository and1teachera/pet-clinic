package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Angel Zlatenov
 */

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
