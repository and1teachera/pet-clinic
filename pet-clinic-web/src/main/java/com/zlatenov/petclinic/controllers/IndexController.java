package com.zlatenov.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Angel Zlatenov
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","index", "index.html"})
    public String index(){
        return "index";
    }
}
