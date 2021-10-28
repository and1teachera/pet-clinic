package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.PetType;
import com.zlatenov.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
@Profile("map")
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {

}
