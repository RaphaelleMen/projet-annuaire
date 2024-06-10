package com.annuaire.api.service;

import com.annuaire.api.controller.model.Employe;
import com.annuaire.api.repository.EmployeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Iterable<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    public Optional<Employe> getEmploye(final Long id) {
        return employeRepository.findById(id);
    }

    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    public Employe updateEmploye(Employe employes) {
        Employe savedEmploye = employeRepository.save(employes);
        return savedEmploye;
    }

    public Employe saveEmploye(Employe employes) {
        Employe savedEmploye = employeRepository.save(employes);
        return savedEmploye;
    }

    public Iterable<Employe> getEmployeNom(String nom) {
        Iterable<Employe> savedEmploye = employeRepository.findByNomContaining(nom);
        return savedEmploye;
    }
}
