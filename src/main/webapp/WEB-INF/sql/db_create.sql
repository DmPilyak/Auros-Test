DROP DATABASE IF EXISTS auros_test_db;
CREATE DATABASE auros_test_db;
CREATE TABLE auros_test_db.k_pac (
	id integer NOT NULL AUTO_INCREMENT,
	Title character varying(250),
    Description_k_pac character varying(2000),
    Creation_date character varying(10),
	CONSTRAINT k_pac_pkey PRIMARY KEY (id) );
    
    CREATE TABLE `auros_test_db`.`kpac_set_kpac` (
  `id_set` INT NOT NULL,
  `id_kpac` INT NOT NULL);


CREATE TABLE `auros_test_db`.`kpac_sets` (
  `id_set` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id_set`));
