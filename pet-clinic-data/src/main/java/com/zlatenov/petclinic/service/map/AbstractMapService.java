package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.exceptions.SavingNullObjectsException;
import com.zlatenov.petclinic.model.BaseEntity;
import com.zlatenov.petclinic.service.CrudOperationsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public abstract class AbstractMapService<T extends BaseEntity> implements CrudOperationsService<T> {

    protected Map<Long,T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(final Long id){
        return map.get(id);
    }

    public T save(T t){
        if(t == null){
            throw new SavingNullObjectsException();
        }
        t.setId((t.getId() != null ? t.getId() : getNextId()));
        map.put(t.getId(), t);

        return t;
    }

    @Transactional
    public Collection<T> saveAll(final Collection<T> collection){
        collection.forEach(this::save);
        return collection;
    }

    public void deleteById(Long id){
        map.remove(id);
    }

    public void delete(T t){
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId(){
        return (long) (map.keySet().size() + 1);
    }
}
