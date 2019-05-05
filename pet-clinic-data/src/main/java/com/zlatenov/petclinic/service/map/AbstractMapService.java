package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.BaseEntity;
import com.zlatenov.petclinic.service.CrudOperationsService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Angel Zlatenov
 */

public abstract class AbstractMapService<T extends BaseEntity<ID>, ID> implements CrudOperationsService<T, ID> {

    protected Map<ID,T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T findById(final ID id){
        return map.get(id);
    }

    public T save(T t){
        if(t == null){
            throw new RuntimeException("We cannot save null object");
        }
        t.setId((ID) (t.getId() != null ? (Long) t.getId() : getNextId()));
        map.put(t.getId(), t);

        return t;
    }

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T t){
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId(){
        return (long) (map.keySet().size() + 1);
    }
}
