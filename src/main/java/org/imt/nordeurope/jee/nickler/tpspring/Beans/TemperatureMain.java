package org.imt.nordeurope.jee.nickler.tpspring.Beans;

import org.imt.nordeurope.jee.nickler.tpspring.Commons.TemperatureBean;

import javax.annotation.PostConstruct;

public class TemperatureMain {
    public TemperatureBean frBean;
    public TemperatureBean deBean;
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
