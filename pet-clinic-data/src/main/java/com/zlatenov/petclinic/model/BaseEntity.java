package com.zlatenov.petclinic.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Angel Zlatenov
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
