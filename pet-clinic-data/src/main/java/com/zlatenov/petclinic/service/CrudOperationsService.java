package com.zlatenov.petclinic.service;

import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public interface BasicCrudOperationsService<T> {

    T findById(Long id);

    T save(T t);

    Set<T> findAll();
}
