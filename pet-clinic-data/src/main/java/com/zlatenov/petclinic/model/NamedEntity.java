package com.zlatenov.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Angel Zlatenov
 */
@Getter
@Setter
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column
    private String name;
}
