package com.zlatenov.petclinic.actuator;

/**
 * @author Angel Zlatenov
 */

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "awareBeans")
public class AwareBeansEndpoint {

    private final ListableBeanFactory beanFactory;

    public AwareBeansEndpoint(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @ReadOperation
    public List<String> getAwareBeans() {
        return new ArrayList<>(beanFactory.getBeansOfType(Aware.class)
                .keySet());
    }
}

