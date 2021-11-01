package com.zlatenov.petclinic.repository;

import com.zlatenov.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Angel Zlatenov
 */

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);
}
