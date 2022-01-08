package org.imt.nordeurope.jee.nickler.tpspring.Controllers;

import org.imt.nordeurope.jee.nickler.tpspring.Annotations.AnnotationTemperatureMain;
import org.imt.nordeurope.jee.nickler.tpspring.Beans.TemperatureMain;
import org.imt.nordeurope.jee.nickler.tpspring.Commons.TemperatureBean;
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

    @Autowired
    AnnotationTemperatureMain annotationTemperatureMain;

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
        setAttribute(model, bean.frBean, bean.deBean,bean.enBean);
        return "temperatures";
    }

    @RequestMapping(value = {"/temperaturesAnnotation" }, method = RequestMethod.GET)
    public String temperaturesAnnotation(Model model) {

        setAttribute(model,annotationTemperatureMain.frBean, annotationTemperatureMain.deBean, annotationTemperatureMain.enBean);
        return "temperatures";
    }

    private void setAttribute(Model model, TemperatureBean frBean, TemperatureBean deBean, TemperatureBean enBean) {
        model.addAttribute("temperatureFR", frBean.getTemperature());
        model.addAttribute("temperatureDE", deBean.getTemperature());
        model.addAttribute("temperatureEN", enBean.getTemperature());

        model.addAttribute("hashCodeFR", frBean.getHash());
        model.addAttribute("hashCodeDE", deBean.getHash());
        model.addAttribute("hashCodeEN", enBean.getHash());
    }

}
