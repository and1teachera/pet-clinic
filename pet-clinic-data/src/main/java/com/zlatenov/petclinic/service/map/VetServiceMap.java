package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Vet;
import com.zlatenov.petclinic.service.VetService;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
