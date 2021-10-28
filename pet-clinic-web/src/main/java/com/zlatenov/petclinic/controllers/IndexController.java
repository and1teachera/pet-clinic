package com.zlatenov.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Angel Zlatenov
 */
@Controller
public class IndexController {

    @GetMapping({"","/","index", "index.html"})
    public String index(){
        return "index";
    }


    @GetMapping("/oups")
    public ModelAndView oups(ModelAndView modelAndView){
        modelAndView.setViewName("notimplemented");
        return modelAndView;
    }
}
