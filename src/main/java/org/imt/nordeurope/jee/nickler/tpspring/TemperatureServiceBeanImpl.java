package org.imt.nordeurope.jee.nickler.tpspring;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TemperatureServiceBeanImpl implements TemperatureServiceBean {

    public static Map<String, Integer> temperatureByCountries;

    static {
        temperatureByCountries = new HashMap();
        temperatureByCountries.put("fr",10);
        temperatureByCountries.put("en",8);
        temperatureByCountries.put("de",12);
    }

    @Override
    public BigDecimal getTemperature(String country){
        BigDecimal temp = BigDecimal.valueOf(temperatureByCountries.get(country));
        temperatureByCountries.put(country, temperatureByCountries.get(country) + 1);
        return temp;
    }
}
