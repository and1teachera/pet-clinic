package com.zlatenov.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
