package com.annuaire.api.service;

import com.annuaire.api.controller.EmployeController;
import com.annuaire.api.controller.model.Employe;
import com.annuaire.api.controller.model.Global;
import com.annuaire.api.repository.EmployeRepository;
import com.annuaire.api.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalService {

    @Autowired
    private GlobalRepository globalRepository;
    @Autowired
    private EmployeController employeController;
    public List<Global> getGlobal(String nom, Integer service, Integer site){
        Iterable<Employe> employes = employeController.getEmployeNom(nom);
        return globalRepository.getAll(employes, service, site);
    }
}
