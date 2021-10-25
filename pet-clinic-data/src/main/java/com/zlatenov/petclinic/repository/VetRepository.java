package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface VetRepository extends CrudRepository<Vet, Long> {
}