package org.imt.nordeurope.jee.nickler.tpspring;

import org.imt.nordeurope.jee.nickler.tpspring.Annotations.AnnotationTemperatureMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MainController {
    public static ApplicationContext applicationContext;

    //@Autowired
    public AnnotationTemperatureMain annotationTemperatureMain;


    static {
        applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = {"/temperatures" }, method = RequestMethod.GET)
    public String temperatures(Model model) {
        TemperatureMain bean = applicationContext.getBean(TemperatureMain.class);
        model.addAttribute("temperatureFR",bean.frBean.getTemperature());
        model.addAttribute("temperatureDE",bean.deBean.getTemperature());
        model.addAttribute("temperatureEN",bean.enBean.getTemperature());

        model.addAttribute("hashCodeFR",bean.frBean.getHash());
        model.addAttribute("hashCodeDE",bean.deBean.getHash());
        model.addAttribute("hashCodeEN",bean.enBean.getHash());
        return "temperatures";
    }

    @RequestMapping(value = {"/temperaturesAnnotation" }, method = RequestMethod.GET)
    public String temperaturesAnnotation(Model model) {
        
        model.addAttribute("temperatureFR",annotationTemperatureMain.frBean.getTemperature());
        model.addAttribute("temperatureDE",annotationTemperatureMain.deBean.getTemperature());
        model.addAttribute("temperatureEN",annotationTemperatureMain.enBean.getTemperature());

        model.addAttribute("hashCodeFR",annotationTemperatureMain.frBean.getHash());
        model.addAttribute("hashCodeDE",annotationTemperatureMain.deBean.getHash());
        model.addAttribute("hashCodeEN",annotationTemperatureMain.enBean.getHash());
        return "temperatures";
    }

}
