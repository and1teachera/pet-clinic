package com.zlatenov.petclinic.actuator;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Angel Zlatenov
 */
@Component
@Endpoint(id = "beanpostprocessors")
public class BeanPostProcessorsEndpoint {

    private final ListableBeanFactory beanFactory;

    public BeanPostProcessorsEndpoint(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @ReadOperation
    public List<String> beanPostProcessors() {
        return new ArrayList<>(beanFactory.getBeansOfType(BeanPostProcessor.class)
                .keySet());
    }
}
