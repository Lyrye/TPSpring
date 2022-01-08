package org.imt.nordeurope.jee.nickler.tpspring.Annotations;

import org.imt.nordeurope.jee.nickler.tpspring.TemperatureServiceBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "singleton")
public class AnnotationTemperatureServiceBeanImpl implements TemperatureServiceBean {
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
