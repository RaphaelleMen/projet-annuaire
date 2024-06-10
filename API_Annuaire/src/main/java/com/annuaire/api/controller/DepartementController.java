package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Departement;
import com.annuaire.api.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping("/departements")
    public Iterable<Departement> getDepartements() {
        return departementService.getDepartements();
    }

    @GetMapping("/departement/{id}")
    public Optional<Departement> getDepartement(@PathVariable Integer id) {
        return departementService.getDepartement(id);
    }

    @DeleteMapping("/departement/{id}")
    public void deleteDepartement(@PathVariable Integer id) {
        departementService.deleteDepartement(id);
    }

    @PutMapping("/departement")
    public Departement updateService(@RequestBody Departement departement)  {
        return departementService.updateDepartement(departement);
    }

    @PostMapping("/departement")
    public Departement saveDepartement(@RequestBody Departement departement) {
        return departementService.saveDepartement(departement);
    }
}
