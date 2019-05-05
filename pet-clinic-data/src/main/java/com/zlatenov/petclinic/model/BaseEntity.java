package com.zlatenov.petclinic.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Angel Zlatenov
 */
@MappedSuperclass
public class BaseEntity<ID> implements Serializable {

    private ID id;

    public ID getId() {
        return this.id;
    }

    public void setId(final ID id) {
        this.id = id;
    }
}
