package com.zlatenov.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@Entity
@Table(name = "Specialties")
public class Speciality extends BaseEntity {

    @Column
    private String description;

}
