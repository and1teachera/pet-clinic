package com.zlatenov.petclinic.service;

import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public interface CrudOperationsService<T, ID> {

    T findById(ID id);

    T save(T t);

    Set<T> findAll();

    void delete(T t);

    void deleteById(ID id);
}
