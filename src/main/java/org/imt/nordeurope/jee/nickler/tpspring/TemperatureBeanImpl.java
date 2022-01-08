package org.imt.nordeurope.jee.nickler.tpspring;

import java.math.BigDecimal;

public class TemperatureBeanImpl implements TemperatureBean {
    private String name;
    TemperatureServiceBean service;

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
