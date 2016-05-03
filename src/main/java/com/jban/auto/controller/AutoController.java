package com.jban.auto.controller;

import com.jban.auto.model.Automobile;
import com.jban.auto.service.AutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/automobiles/add", method = RequestMethod.POST)
    public String addAuto(@ModelAttribute("auto") Automobile auto){
        if(auto.getId()==0){
            this.autoService.addAuto(auto);
        }
        else {
            this.autoService.updateAuto(auto);
        }
        return "redirect:/automobiles";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuto(@PathVariable("id") int id){
        this.autoService.deleteAuto(id);

        return "redirect:/automobiles";
    }

    @RequestMapping("edit/{id}")
    public String editAuto(@PathVariable("id") int id, Model model){
        model.addAttribute("auto", this.autoService.getAutoById(id));
        model.addAttribute("listAutos", this.autoService.listAutos());

        return "automobiles";
    }

    @RequestMapping("autodata/{id}")
    public String autoData(@PathVariable("id") int id, Model model){
        model.addAttribute("auto", this.autoService.getAutoById(id));

        return "autodata";
    }

}
