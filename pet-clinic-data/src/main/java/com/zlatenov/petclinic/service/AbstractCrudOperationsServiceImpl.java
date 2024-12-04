package com.zlatenov.petclinic.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */
@AllArgsConstructor
public class AbstractCrudOperationsServiceImpl<T, R extends JpaRepository<T, Long>> implements CrudOperationsService<T> {

    protected final R repository;

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Collection<T> saveAll(Collection<T> collection) {
        return repository.saveAll(collection);
    }
}
