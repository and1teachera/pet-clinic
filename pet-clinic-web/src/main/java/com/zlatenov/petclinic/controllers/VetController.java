package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Angel Zlatenov
 */
@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","index", "index.html",".html"})
    public String listVets(Model model){
        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }

}
