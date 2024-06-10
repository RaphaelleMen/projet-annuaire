DROP DATABASE IF EXISTS ANNUAIRE;
CREATE DATABASE ANNUAIRE;
USE ANNUAIRE;


CREATE TABLE Sites(
   id_site INT auto_increment,
   nom_site VARCHAR(50),
   role_site VARCHAR(50),
   PRIMARY KEY(id_site)
);

insert into Sites (id_site, nom_site, role_site) values
(1, "Paris", "administratif"),
(2, "Nantes", "production"),
(3, "Toulouse", "production"),
(4, "Nice", "production"),
(5, "Lille", "production");

CREATE TABLE Services (
  id_service INT auto_increment,
  nom_service VARCHAR(100),
  abv VARCHAR(6),
  PRIMARY KEY(id_service)
);

insert into Services (id_service, nom_service, abv) values
(1, "Comptabilité", "COMPTA"),
(2, "Production", "PROD"),
(3, "Accueil", "ACC"),
(4, "Informatique", "INFO"),
(5, "Juridique", "JUR"),
(6, "Commercial", "VENTE"),
(7, "Gestion Site", "FONC"),
(8, "Communication Marketing", "COMM");

CREATE TABLE Coordonnees(
   id BIGINT auto_increment,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   telephone_fixe VARCHAR(10) NOT NULL,
   telephone_portable VARCHAR(10),
   mail VARCHAR(50),
   fk_site INT,
   fk_service INT,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_site) REFERENCES Sites(id_site),
   FOREIGN KEY(fk_service) REFERENCES Services(id_service)
);

DELIMITER //

CREATE PROCEDURE CreationEmployes(IN effectif INT)
BEGIN
  DECLARE i INT DEFAULT 0;
  DECLARE valeur_nom VARCHAR(50);
  DECLARE valeur_prenom VARCHAR(50);
  DECLARE valeur_telephone_fixe VARCHAR(10);
  DECLARE valeur_telephone_portable VARCHAR(10);
  DECLARE valeur_mail VARCHAR(50);
  DECLARE valeur_fk_site INT;
  DECLARE valeur_fk_service INT;

  SET i = 0;

WHILE i < effectif DO
    SET valeur_nom = CONCAT('Nom', i);
    SET valeur_prenom = CONCAT('Prenom', i);
    SET valeur_telephone_fixe = CONCAT('0', LPAD(FLOOR(RAND() * 100000000), 9, '0'));
    SET valeur_telephone_portable = CONCAT('0', LPAD(FLOOR(RAND() * 100000000), 9, '0'));
    SET valeur_mail = CONCAT('email', i, '@agroentreprise.com');
    SET valeur_fk_site = FLOOR(RAND() * 5) + 1;
    SET valeur_fk_service = FLOOR(RAND() * 8) + 1;

    INSERT INTO Coordonnees (nom, prenom, telephone_fixe, telephone_portable, mail, fk_site, fk_service)
    VALUES (valeur_nom, valeur_prenom, valeur_telephone_fixe, valeur_telephone_portable, valeur_mail, valeur_fk_site, valeur_fk_service);

    SET i = i + 1;
END WHILE;
END //

DELIMITER ;

CALL CreationEmployes(1000);
