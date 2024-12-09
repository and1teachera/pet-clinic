package com.zlatenov.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@Entity
@Table(name = "Specialties")
public class Speciality extends NamedEntity {


    @Column
    private String description;

}
