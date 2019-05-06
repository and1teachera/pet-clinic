package com.zlatenov.petclinic.service;

import java.util.Collection;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public interface CrudOperationsService<T> {

    T findById(Long id);

    T save(T t);

    Set<T> findAll();

    void delete(T t);

    void deleteById(Long id);

    Collection<T> saveAll(Collection<T> collection);
}
