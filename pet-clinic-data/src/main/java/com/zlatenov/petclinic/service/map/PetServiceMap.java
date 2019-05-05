package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Pet;
import com.zlatenov.petclinic.service.PetService;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
