package org.imt.nordeurope.jee.nickler.tpspring;

import java.math.BigDecimal;

public interface TemperatureServiceBean {
    BigDecimal getTemperature(String country);
}
