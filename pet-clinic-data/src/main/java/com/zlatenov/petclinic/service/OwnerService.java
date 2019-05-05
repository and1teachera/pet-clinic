package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.Owner;

/**
 * @author Angel Zlatenov
 */

public interface OwnerService extends CrudOperationsService<Owner,Long> {

    Owner findByLastName(String lastName);
}
