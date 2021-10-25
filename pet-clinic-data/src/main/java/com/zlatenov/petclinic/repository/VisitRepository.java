package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
