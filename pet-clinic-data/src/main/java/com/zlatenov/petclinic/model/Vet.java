package com.zlatenov.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
