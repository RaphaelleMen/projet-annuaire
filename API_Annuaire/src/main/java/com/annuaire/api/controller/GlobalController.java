package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Global;
import com.annuaire.api.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(" ") adresse client lourd à indiquer
public class GlobalController {
    @Autowired
    private GlobalService globalService;

    @GetMapping("/global")
    public List<Global> getGlobal(@RequestParam(required = false) String nom, @RequestParam(required = false) Integer service, @RequestParam(required = false) Integer site) {
        return globalService.getGlobal(nom, service, site);
    }
}
