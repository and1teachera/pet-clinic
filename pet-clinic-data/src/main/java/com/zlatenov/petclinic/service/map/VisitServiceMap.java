package com.zlatenov.petclinic.service.map;

import com.zlatenov.petclinic.model.Visit;
import com.zlatenov.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Angel Zlatenov
 */
@Service
@Profile("map")
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
}
