package com.zlatenov.petclinic.model;

import jakarta.persistence.Entity;

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
