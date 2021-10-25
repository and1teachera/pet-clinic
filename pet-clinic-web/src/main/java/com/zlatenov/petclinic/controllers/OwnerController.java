package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Angel Zlatenov
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","index", "index.html"})
    public String listOwners(final Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public ModelAndView find(ModelAndView modelAndView){
        modelAndView.setViewName("notimplemented");
        return modelAndView;
    }

}
