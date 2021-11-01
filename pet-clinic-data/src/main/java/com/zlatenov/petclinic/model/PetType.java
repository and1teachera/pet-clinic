package com.zlatenov.petclinic.model;

import javax.persistence.Entity;

/**
 * @author Angel Zlatenov
 */
@Entity
public class PetType extends NamedEntity {

    @Override
    public String toString() {
        return getName();
    }
}
