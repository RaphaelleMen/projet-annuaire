package com.annuaire.api.controller.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Sites")

public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_site")
    private Integer id;

    @Column(name = "nom_site")
    private String ville;

    @Column(name = "role_site")
    private String type;
}
