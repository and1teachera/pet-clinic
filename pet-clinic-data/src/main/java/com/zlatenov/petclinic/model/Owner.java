package com.zlatenov.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String name, boolean ignoreNew) {
        if (name == null || name.isBlank()) {
            return null;
        }
        String nameLowerCase = name.toLowerCase();
        return pets.stream()
                .filter(pet -> !ignoreNew && !pet.isNew())
                .filter(pet -> nameLowerCase.equals(pet.getName().toLowerCase()))
                .findFirst()
                .orElse(null);
    }

}
