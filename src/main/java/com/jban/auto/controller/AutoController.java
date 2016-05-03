package com.jban.auto.controller;

import com.jban.auto.model.Automobile;
import com.jban.auto.service.AutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutoController {
    private AutoService autoService;

    @Autowired(required = true)
    @Qualifier(value = "autoService")
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @RequestMapping(value = "automobiles", method = RequestMethod.GET)
    public String listAutos(Model model){
        model.addAttribute("auto", new Automobile());
        model.addAttribute("listAutos", this.autoService.listAutos());

        return "automobiles";
    }
}
