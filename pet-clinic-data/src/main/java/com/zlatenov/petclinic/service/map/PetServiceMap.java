package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
@Profile("map")
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
