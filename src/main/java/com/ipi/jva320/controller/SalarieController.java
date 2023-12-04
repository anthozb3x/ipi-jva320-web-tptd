package com.ipi.jva320.controller;

import com.ipi.jva320.model.SalarieAideADomicile;
import com.ipi.jva320.service.SalarieAideADomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
