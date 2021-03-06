-- MySQL Script generated by MySQL Workbench
-- 02/01/17 21:46:06
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema interativa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema interativa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `interativa` DEFAULT CHARACTER SET utf8 ;
USE `interativa` ;

-- -----------------------------------------------------
-- Table `interativa`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interativa`.`categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interativa`.`modelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interativa`.`modelo` (
  `id_modelo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_modelo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interativa`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interativa`.`item` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT NOT NULL,
  `numeroserial` VARCHAR(150) NOT NULL,
  `id_modelo` INT NOT NULL,
  `emestoque` INT NOT NULL,
  PRIMARY KEY (`id_item`),
  INDEX `fk_Item_Categoria_idx` (`id_categoria` ASC),
  INDEX `fk_item_modelo1_idx` (`id_modelo` ASC),
  CONSTRAINT `fk_Item_Categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `interativa`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_modelo1`
    FOREIGN KEY (`id_modelo`)
    REFERENCES `interativa`.`modelo` (`id_modelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interativa`.`tipomovimentacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interativa`.`tipomovimentacao` (
  `id_tipomovimentacao` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  PRIMARY KEY (`id_tipomovimentacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `interativa`.`movimentacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interativa`.`movimentacao` (
  `id_movimentacao` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `id_tipomovimentacao` INT NOT NULL,
  `id_item` INT NOT NULL,
  PRIMARY KEY (`id_movimentacao`),
  INDEX `fk_movimentacao_tipomovimentacao1_idx` (`id_tipomovimentacao` ASC),
  INDEX `fk_movimentacao_item1_idx` (`id_item` ASC),
  CONSTRAINT `fk_movimentacao_tipomovimentacao1`
    FOREIGN KEY (`id_tipomovimentacao`)
    REFERENCES `interativa`.`tipomovimentacao` (`id_tipomovimentacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimentacao_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `interativa`.`item` (`id_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
