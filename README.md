# Enzo-JavaWeb
Eclipse y Java
Instalar el driver para la correcta conexión de BD.

By:Enzo Gonzales
-- Utilizar la BD MySQL.
-- Copiar y pegar el siguiente código:

-- Conexion con la BD MySQL.
--
-- Crar la Base de datos:
CREATE DATABASE SEGUROSBD;
-- Usar la Base de datos
USE SEGUROSBD;
-- Crear la Tabla TAFILIADO
CREATE TABLE TAFILIADO(
  IDAFILIADO INT NOT NULL AUTO_INCREMENT,
  ID_FUNCIONARIO INT NOT NULL,
  CLIENTE VARCHAR(50),
  PAGO DECIMAL(5,2),
  ESTADO INT,
  PRIMARY KEY (IDAFILIADO),
  CONSTRAINT TAFILIADO_FK FOREIGN KEY (ID_FUNCIONARIO) REFERENCES TFUNCIONARIO (ID_FUNCIONARIO)
);
-- Crear la Tabla TFUNCIONARIO
CREATE TABLE TFUNCIONARIO (
  ID_FUNCIONARIO INT NOT NULL AUTO_INCREMENT,
  NOMBRE varchar(50) DEFAULT NULL,
  PRIMARY KEY (ID_FUNCIONARIO)
);

select t.IDAFILIADO, f.ID_FUNCIONARIO, t.CLIENTE,t.PAGO,t.estado from TAFILIADO t inner join TFUNCIONARIO f on t.ID_FUNCIONARIO= f.ID_FUNCIONARIO;
select t.IDAFILIADO, f.NOMBRE, t.CLIENTE,t.PAGO,t.estado from TAFILIADO t inner join TFUNCIONARIO f on t.ID_FUNCIONARIO= f.ID_FUNCIONARIO


-- End
