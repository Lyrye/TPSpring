package org.imt.nordeurope.jee.nickler.tpspring.Commons;

import java.math.BigDecimal;

public interface TemperatureBean {

    void printTemperature();
    String getName();
    void setName(String name);
    void setService(TemperatureServiceBean service);
    BigDecimal getTemperature ();
    int getHash ();

}
