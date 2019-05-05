package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Owner;
import com.zlatenov.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Angel Zlatenov
 */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    @Override
    public Owner findByLastName(final String lastName) {
        return map.values()
                .stream()
                .filter(owner -> Objects.equals(owner.getFirstName(), lastName))
                .findFirst()
                .orElse(null);
    }
}
