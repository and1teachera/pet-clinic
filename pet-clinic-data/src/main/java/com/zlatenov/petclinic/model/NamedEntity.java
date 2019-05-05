package com.zlatenov.petclinic.model;

/**
 * @author Angel Zlatenov
 */

public class NamedEntity extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
