package com.ipi.jva320.controller;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalarieController {

    @Autowired
    SalarieAideADomicileService salarieService;

    @GetMapping(value = "salaries/{id}")
    public String DetailSalarie(final ModelMap model, @PathVariable Long id){
        SalarieAideADomicile salarieAideADomicile = salarieService.getSalarie(id);
        model.put("salarie",salarieAideADomicile);
        return "detail_Salarie";

    }
    @GetMapping(value = "salaries")
    public String Salaries(final ModelMap model,@RequestParam(required = false) String nom){
        List<SalarieAideADomicile> salarieAideADomicile;
        if(nom != null && !nom.isEmpty()){
            salarieAideADomicile = salarieService.getSalaries(nom);
        }
        else {
            salarieAideADomicile = salarieService.getSalaries();
        }
        model.put("salaries",salarieAideADomicile);
        return "list";
    }

    @GetMapping(value ="/salaries/aide/new")
    public String showForm(Model model) {
        model.addAttribute("salarie", new SalarieAideADomicile());
        return "new_salarie";
    }

    @PostMapping(value ="/salaries/aide/new")
    public String submitForm(@ModelAttribute("salarie") SalarieAideADomicile salarie) throws SalarieException {
        salarieService.creerSalarieAideADomicile(salarie);
        return "redirect:/salaries";
    }


    @PostMapping(value ="/salaries/aide/update")
    public String updateSalarie(SalarieAideADomicile salarie) throws SalarieException {
        System.out.println(salarie.getId());
        salarieService.updateSalarieAideADomicile(salarie);
        return "redirect:/salaries";
    }

    @GetMapping(value = "/salaries/{id}/delete")
    public  String DeleteSalarie(@PathVariable long id) throws SalarieException {
        salarieService.deleteSalarieAideADomicile(id);
        return "redirect:/salaries";
    }





}
