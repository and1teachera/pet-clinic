package com.zlatenov.petclinic.controllers;

import com.zlatenov.petclinic.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Angel Zlatenov
 */
@Controller
@AllArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

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
