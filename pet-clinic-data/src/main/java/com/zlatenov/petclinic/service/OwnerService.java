package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Owner;

import java.util.List;

/**
 * @author Angel Zlatenov
 */

public interface OwnerService extends CrudOperationsService<Owner> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
