CREATE DATABASE db_hospitalgeneral;

USE db_hospitalgeneral;

CREATE TABLE consultas(
idConsulta INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombrePaciente VARCHAR(100),
nss VARCHAR(30),
sintomas VARCHAR(100),
noTurno INT,
nombreDoctor VARCHAR(100),
noConsultorio INT
)ENGINE = INNODB;
