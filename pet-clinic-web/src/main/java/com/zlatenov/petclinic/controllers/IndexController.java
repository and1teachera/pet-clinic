package com.zlatenov.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Angel Zlatenov
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","index", "index.html"})
    public String index(){
        return "index";
    }


    @RequestMapping("/oups")
    public ModelAndView oups(ModelAndView modelAndView){
        modelAndView.setViewName("notimplemented");
        return modelAndView;
    }
}
