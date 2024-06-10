package com.annuaire.api.repository;

import com.annuaire.api.controller.model.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
    Iterable<Employe> findByNomContaining(String nom);
}
