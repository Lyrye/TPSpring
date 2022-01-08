package org.imt.nordeurope.jee.nickler.tpspring.Annotations;

import org.imt.nordeurope.jee.nickler.tpspring.TemperatureBean;
import org.imt.nordeurope.jee.nickler.tpspring.TemperatureServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Primary
@Scope(value = "prototype")
public class AnnotationTemperatureBeanImpl implements TemperatureBean {

    private String name;

    @Autowired
    private TemperatureServiceBean service;

    @Override
    public void printTemperature() {
        System.out.println(service.getTemperature(this.name));
        System.out.println(service.hashCode());
        System.out.println(this.getName());
    }

    @Override
    public BigDecimal getTemperature (){
        return service.getTemperature(this.name);
    }

    @Override
    public int getHash (){
        return service.hashCode();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setService(TemperatureServiceBean service) {
        this.service = service;
    }
}
