package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Employe;
import com.annuaire.api.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes")
    public Iterable<Employe> getArticles(){
        return employeService.getEmployes();
    }

    @GetMapping("/employe/{id}")
    public Optional<Employe> getArticle(@PathVariable Long id){
        return employeService.getEmploye(id);
    }

    @DeleteMapping("/employe/{id}")
    public void deleteArticle(@PathVariable Long id){
        employeService.deleteEmploye(id);
    }

    @PutMapping("/employe")
    public Employe updateArticle(@RequestBody Employe employes){
        return employeService.updateEmploye(employes);
    }

    @PostMapping("/employe")
    public Employe saveArticle(@RequestBody Employe employes){
        return employeService.saveEmploye(employes);
    }

    @GetMapping("/employes/{nom}")
    public Iterable<Employe> getEmployeNom(@PathVariable(required = false) String nom) {
        if (nom != null && !nom.isEmpty()) {
            return employeService.getEmployeNom(nom);
        } else {
            return employeService.getEmployes();
        }
    }
}
