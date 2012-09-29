SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `3JML` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `3JML` ;
-- -----------------------------------------------------
-- Table `3JML`.`MUsuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `3JML`.`MUsuario`  (
  `UsuCodigo` INT NOT NULL AUTO_INCREMENT ,
  `UsuLogin`  VARCHAR(15) DEFAULT '',
  `UsuClave`  VARCHAR(15) DEFAULT '',
  `UsuNombre` VARCHAR(60) DEFAULT '',
  PRIMARY KEY (`UsuCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `3JML`.`MCliente` (
  `CliCodigo`      INT         NOT NULL AUTO_INCREMENT,
  `CliRUC`         VARCHAR(15) DEFAULT '' ,
  `CliRazonSocial` VARCHAR(60) DEFAULT '' ,
  `CliDireccion`   VARCHAR(60) DEFAULT '' ,
  `CliDistrito`    VARCHAR(50) DEFAULT '' ,
  `CliTelefono`    VARCHAR(15) DEFAULT '' ,
  `CliCelular`     VARCHAR(15) DEFAULT '' ,
  `CliCorreo`      VARCHAR(60) DEFAULT '' ,
  `CliContacto`    VARCHAR(60) DEFAULT '' ,
  `CliContactoTel` VARCHAR(15) DEFAULT '' ,
  `CliContactoCor` VARCHAR(60) DEFAULT '' ,
  `CliEstado`      VARCHAR(10) DEFAULT '' ,
  PRIMARY KEY (`CliCodigo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `3JML`.`MProducto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `3JML`.`MProducto` (
  `ProCodigo` INT NOT NULL AUTO_INCREMENT ,
  `ProNombre` VARCHAR(45) DEFAULT '',
  `ProUnivta` VARCHAR(15) DEFAULT '',
  `ProPrecio` DECIMAL(6,2) DEFAULT 0,
  `ProStock`  DECIMAL(10,2) DEFAULT 0,
  PRIMARY KEY (`ProCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MPromociones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `3JML`.`MPromociones` (
  `PrmCodigo` INT NOT NULL AUTO_INCREMENT ,  
  `PrmNombre` VARCHAR(45)  DEFAULT '' ,
  `ProCodigo` INT          DEFAULT 0,
  `PrmCantid` DECIMAL(6,2) DEFAULT 0,
  `PrmPrecio` DECIMAL(6,2) DEFAULT 0,
   PRIMARY KEY (`PrmCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MCPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `3JML`.`MCPedido` (
  `PedCodigo`      INT         NOT NULL AUTO_INCREMENT,
  `CliCodigo`      INT DEFAULT   0,  
  `CliRUC`         VARCHAR(15)   DEFAULT '' ,
  `CliRazonSocial` VARCHAR(60)   DEFAULT '' ,
  `CliDireccion`   VARCHAR(60)   DEFAULT '' ,
  `CliDistrito`    VARCHAR(50)   DEFAULT '' ,
  `PedFecReg`      VARCHAR(10)   DEFAULT '' ,
  `PedFecAte`      VARCHAR(10)   DEFAULT '' ,
  `PedTotal`       DECIMAL(10,2) DEFAULT 0,
  `PedEstado`      CHAR DEFAULT '' ,
  PRIMARY KEY (`PedCodigo`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `3JML`.`MDPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `3JML`.`MDPedido` (
  `PedCodigo`   INT DEFAULT 0,
  `ProCodigo`   INT DEFAULT 0,
  `PedCantidad` INT DEFAULT 0,  
  `ProPrecio`   DECIMAL(6,2) DEFAULT 0,
  `PedParcial`  DECIMAL(10,2) DEFAULT 0,
  PRIMARY KEY (`PedCodigo`,`ProCodigo`) )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JFLORES','JUDITH','JUDITH FLORES PARREÑO');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JZAVALA','JOSE','JOSE ZAVALA FELIX');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('JORTEAGA','JUAN','JUAN ORTEAGA MONTALVO');
INSERT INTO `3JML`.`MUsuario` (`UsuLogin`,`UsuClave`,`UsuNombre`) VALUES('LMIGUEL','LUIS','LUIS MIGUEL ESPINOZA');

INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('MILO','UNIDAD',14.00,10);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('CAFE','UNIDAD',8.90,20);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('LECHE','KILO',14.00,30);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('AZUCAR','KILO',19.00,40);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('ARROZ','KILO',24.00,10);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('JABON','DOCENA',8.00,20);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('PAPEL HIGIENICO','PLANCHA',14.99,30);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('COCA COLA','DOCENA',4.90,40);
INSERT INTO `3JML`.`MProducto` (`ProNombre`,`ProUnivta`,`ProPrecio`,`ProStock`) VALUES('CERVEZA CUSQUEÑA','DOCENA',15.50,50);

INSERT INTO `3JML`.`MPromociones` (`PrmNombre`,`ProCodigo`,`PrmCantid`,`PrmPrecio`) VALUES('MILO PLUS 2012',1,20.00,15.00);
INSERT INTO `3JML`.`MPromociones` (`PrmNombre`,`ProCodigo`,`PrmCantid`,`PrmPrecio`) VALUES('PRIMAVERA 2012',5,100.00,50.00);

INSERT INTO `3JML`.`MCliente` (`CliRUC`,`CliRazonSocial`,`CliDireccion`,`CliDistrito`,`CliTelefono`,`CliCelular`,`CliCorreo`, `CliContacto`,`CliContactoTel`,`CliContactoCor`,`CliEstado`) 
Values('20102097654','BODEGA CHACARILLA SCR LTDA','JR. JIRON MONTEGRANDE #197','SANTIAGO DE SURCO','365676','365676','bodegachacarilla@3jml.com.pe','','','','Activo');

 