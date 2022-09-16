-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `mydb`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `animators_num` INT(2) NULL,
  `visitors_num` INT(3) NULL,
  `date` DATE NOT NULL,
  `address` VARCHAR(30) NOT NULL,
  `duration_in_hours` INT(2) UNSIGNED NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_event_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `mydb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`discount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(35) NULL,
  `percentage` INT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`client_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`client_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `discount_percentage` INT(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(25) NOT NULL,
  `second_name` VARCHAR(30) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `client_card_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_client_client_card1_idx` (`client_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_client_card1`
    FOREIGN KEY (`client_card_id`)
    REFERENCES `mydb`.`client_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`entertainment_agency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`entertainment_agency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `contact_number` VARCHAR(20) NOT NULL,
  `address` VARCHAR(30) NULL,
  `animator_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_entertainment_agency_animator1_idx` (`animator_id` ASC) VISIBLE,
  INDEX `fk_entertainment_agency_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_entertainment_agency_animator1`
    FOREIGN KEY (`animator_id`)
    REFERENCES `mydb`.`party_animator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_entertainment_agency_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `mydb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(35) NOT NULL,
  `cost_in_usd` INT(5) UNSIGNED NOT NULL,
  `event_id` INT NOT NULL,
  `discount_id` INT NULL,
  `client_id` INT NOT NULL,
  `entertainment_agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_order_discount1_idx` (`discount_id` ASC) VISIBLE,
  INDEX `fk_order_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_order_entertainment_agency1_idx` (`entertainment_agency_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `mydb`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_discount1`
    FOREIGN KEY (`discount_id`)
    REFERENCES `mydb`.`discount` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `mydb`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_entertainment_agency1`
    FOREIGN KEY (`entertainment_agency_id`)
    REFERENCES `mydb`.`entertainment_agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`party_animator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`party_animator` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(25) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `unique_performance` VARCHAR(30) NULL,
  `work_experience_in_years` INT(2) UNSIGNED NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_animator_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_animator_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`consultant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`consultant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(25) NOT NULL,
  `second_name` VARCHAR(30) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `entertainment_agency_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_agency_worker_entertainment_agency1_idx` (`entertainment_agency_id` ASC) VISIBLE,
  CONSTRAINT `fk_agency_worker_entertainment_agency1`
    FOREIGN KEY (`entertainment_agency_id`)
    REFERENCES `mydb`.`entertainment_agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
