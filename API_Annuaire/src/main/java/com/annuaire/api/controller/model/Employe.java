package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Coordonnees")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    @Column(name="telephone_fixe")
    private String telephoneFixe;

    @Column(name="telephone_portable")
    private String telephonePortable;

    @Column(name="mail")
    private String email;

    @Column(name="fk_site")
    private int fkSite;

    @Column(name="fk_service")
    private int fkService;
}
