package com.annuaire.api.service;

import com.annuaire.api.controller.model.Departement;
import com.annuaire.api.repository.DepartementRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public Iterable<Departement> getDepartements() {
        return departementRepository.findAll();
    }

    public Optional<Departement> getDepartement(final int id) {
        return departementRepository.findById(id);
    }

    public void deleteDepartement(final int id) {
        departementRepository.deleteById(id);
    }

    public Departement updateDepartement(Departement departement) {
        Departement savedDepartement = departementRepository.save(departement);
        return savedDepartement;
    }
    public Departement saveDepartement(Departement departement) {
        Departement savedDepartement = departementRepository.save(departement);
        return savedDepartement;
    }

}
