package org.imt.nordeurope.jee.nickler.tpspring.Annotations;

import org.imt.nordeurope.jee.nickler.tpspring.TemperatureBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AnnotationTemperatureMain {

    @Qualifier("annotationTemperatureBeanImpl")
    @Autowired
    public TemperatureBean frBean;

    @Qualifier("annotationTemperatureBeanImpl")
    @Autowired
    public TemperatureBean deBean;

    @Qualifier("annotationTemperatureBeanImpl")
    @Autowired
    public TemperatureBean enBean;

    public void printTemperatureOfCountry(String country){
        switch(country){
            case "fr":
                frBean.printTemperature();
                break;
            case "de":
                deBean.printTemperature();
                break;
            case "en":
                enBean.printTemperature();
                break;
            default:
                break;
        }
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Post Construct ...");
        frBean.setName("fr");
        deBean.setName("de");
        enBean.setName("en");
    }

    public void printTemperatures(){
        System.out.println("Printing Temperatures");
        for(int i =0;i<4;i++){
            printTemperatureOfCountry(frBean.getName());
            printTemperatureOfCountry(enBean.getName());
            printTemperatureOfCountry(deBean.getName());
        }
    }

    public void setFrBean(TemperatureBean frBean) {
        this.frBean = frBean;
    }

    public void setDeBean(TemperatureBean deBean) {
        this.deBean = deBean;
    }

    public void setEnBean(TemperatureBean enBean) {
        this.enBean = enBean;
    }
}
