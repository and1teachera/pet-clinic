package com.zlatenov.petclinic.service;

import com.zlatenov.petclinic.model.BaseEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Angel Zlatenov
 */
abstract class AbstractCrudOperationsServiceImplTest<T extends BaseEntity, R extends JpaRepository<T, Long>, S extends CrudOperationsService<T>> {

    protected R repository;

    protected S service;
    protected List<T> collection;
    protected Class<T> aClass;

    void setUp() {
        T element1 = null;
        T element2 = null;
        try {
            element1 = aClass.getDeclaredConstructor().newInstance();
            element2 = aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        long id1 = 1L;
        element1.setId(id1);

        long id2 = 2L;
        element2.setId(id2);
        this.collection = Arrays.asList(element1, element2);
    }

    @Test
    @DisplayName("Should find by ID")
    void shouldFindById() {
        T element = collection.get(0);
        when(repository.findById(element.getId())).thenReturn(Optional.of(element));

        T elementById = service.findById(element.getId());

        assertNotNull(elementById);
        assertEquals(element.getId(), elementById.getId());
    }

    @Test
    @DisplayName("Should save entity")
    void shouldSave() {
        T element = collection.get(0);
        when(repository.save(any())).thenReturn(element);

        T savedOwner = service.save(element);
        assertNotNull(savedOwner);
        assertEquals(element.getId(), savedOwner.getId());

        verify(repository).save(any());
    }

    @Test
    @DisplayName("Should find all entities")
    void shouldFindAll() {
        when(repository.findAll()).thenReturn(collection);

        Set<T> elementsSet = service.findAll();
        assertEquals(collection.size(), elementsSet.size());

        assertTrue(elementsSet.stream().anyMatch(element -> element.getId().equals(collection.get(0).getId())));
        assertTrue(elementsSet.stream().anyMatch(element -> element.getId().equals(collection.get(1).getId())));
    }

    @Test
    @DisplayName("Should delete entity")
    void shouldDelete() {
        service.delete(collection.get(0));

        verify(repository).delete(any());
    }

    @Test
    @DisplayName("Should delete by ID")
    void shouldDeleteById() {
        T element = collection.get(0);
        service.deleteById(element.getId());

        verify(repository).deleteById(element.getId());
    }

    @Test
    @DisplayName("Should save all entities")
    void shouldSaveAll() {
        when(repository.saveAll(any())).thenReturn(collection);

        Collection<T> savedElements = service.saveAll(this.collection);
        assertEquals(collection.size(), savedElements.size());

        assertTrue(savedElements.stream().anyMatch(element -> element.getId().equals(collection.get(0).getId())));
        assertTrue(savedElements.stream().anyMatch(element -> element.getId().equals(collection.get(1).getId())));

        verify(repository).saveAll(any());
    }
}