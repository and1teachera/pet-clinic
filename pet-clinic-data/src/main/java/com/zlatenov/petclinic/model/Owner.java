package com.zlatenov.petclinic.model;

import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(final Set<Pet> pets) {
        this.pets = pets;
    }
}
