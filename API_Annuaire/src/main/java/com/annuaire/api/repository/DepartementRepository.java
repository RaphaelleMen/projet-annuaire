package com.annuaire.api.repository;

import com.annuaire.api.controller.model.Departement;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement, Integer> {
}
