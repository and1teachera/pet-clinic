package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Angel Zlatenov
 */

public interface VetRepository extends JpaRepository<Vet, Long> {
}