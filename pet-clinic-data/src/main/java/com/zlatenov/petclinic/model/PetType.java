package com.zlatenov.petclinic.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Angel Zlatenov
 */
@NoArgsConstructor
@Entity
public class PetType extends NamedEntity {


    @Builder
    public PetType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
