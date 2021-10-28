package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Speciality;
import com.zlatenov.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
@Profile("map")
public class SpecialityServiceMap extends AbstractMapService<Speciality> implements SpecialityService {

}
