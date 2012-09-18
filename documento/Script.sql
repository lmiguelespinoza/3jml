SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `3JML` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `3JML` ;
-- -----------------------------------------------------
-- Table `3JML`.`MUsuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `3JML`.`MUsuario` (
  `UsuCodigo` INT NOT NULL AUTO_INCREMENT ,
  `UsuLogin`  VARCHAR(15) NULL ,
  `UsuClave`  VARCHAR(15) NULL ,
  `UsuNombre` VARCHAR(60) NULL ,
  PRIMARY KEY (`UsuCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `3JML`.`MCliente` (
  `CliCodigo`      INT         NOT NULL AUTO_INCREMENT,
  `CliRUC`         VARCHAR(15) NULL ,
  `CliRazonSocial` VARCHAR(60) NULL ,
  `CliDireccion`   VARCHAR(60) NULL ,
  `CliDistrito`    VARCHAR(50) NULL ,
  `CliTelefono`    VARCHAR(15) NULL ,
  `CliCelular`     VARCHAR(15) NULL ,
  `CliCorreo`      VARCHAR(60) NULL ,
  `CliContacto`    VARCHAR(60) NULL ,
  `CliContactoTel` VARCHAR(15) NULL ,
  `CliContactoCor` VARCHAR(60) NULL ,
  `CliEstado`      VARCHAR(10) NULL ,
  PRIMARY KEY (`CliCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MProducto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `3JML`.`MProducto` (
  `ProCodigo` INT NOT NULL AUTO_INCREMENT ,
  `ProNombre` VARCHAR(45) NULL ,
  `ProPrecio` DECIMAL(6,2) NULL ,
  `ProOferta` CHAR NULL ,
  PRIMARY KEY (`ProCodigo`) )
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JFLORES','JUDITH','JUDITH FLORES PARREÑO');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JZAVALA','JOSE','JOSE ZAVALA FELIX');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JORTEAGA','JUAN','JUAN ORTEAGA MONTALVO');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('LMIGUEL','LUIS','LUIS MIGUEL ESPINOZA');

INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('MILO',14.0,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('CAFE',8.90,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('LECHE',14.0,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('AZUCAR',19.0,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('ARROZ',24.0,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('JABON',8.0,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('PAPEL HIGIÉNICO',14.99,'N');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('Coca Cola',4.90,'S');
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProPrecio`,`ProOferta`) VALUES('CERVEZA CUSQUEÑA',15.50,'S');
  
INSERT INTO `3JML`.`MCliente` (`CliRUC`,`CliRazonSocial`,`CliDireccion`,`CliDistrito`,`CliTelefono`,`CliCelular`,`CliCorreo`, `CliContacto`,`CliContactoTel`,`CliContactoCor`,`CliEstado`) 
Values('20102097654','BODEGA CHACARILLA SCR LTDA','JR. JIRON MONTEGRANDE #197','SANTIAGO DE SURCO','365676','365676','bodegachacarilla@3jml.com.pe','','','','Activo');

  
  