package com.zlatenov.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

}
