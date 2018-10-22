-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nesterovich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nesterovich` ;

-- -----------------------------------------------------
-- Schema nesterovich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nesterovich` DEFAULT CHARACTER SET utf8 ;
USE `nesterovich` ;

-- -----------------------------------------------------
-- Table `nesterovich`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`roles` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nesterovich`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`users` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(60) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `firstName` VARCHAR(50) NULL,
  `lastName` VARCHAR(50) NULL,
  `phoneNumber` INT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `nesterovich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nesterovich`.`films`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`films` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`films` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(60) NOT NULL,
  `genre` VARCHAR(60) NOT NULL,
  `yearOfIssue` INT NOT NULL,
  `duration` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nesterovich`.`cinemas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`cinemas` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`cinemas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nesterovich`.`films_cinemas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`films_cinemas` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`films_cinemas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `films_id` INT NOT NULL,
  `cinemas_id` INT NOT NULL,
  INDEX `fk_films_cinemas_films1_idx` (`films_id` ASC),
  INDEX `fk_films_cinemas_cinemas1_idx` (`cinemas_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_films_cinemas_films1`
    FOREIGN KEY (`films_id`)
    REFERENCES `nesterovich`.`films` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_films_cinemas_cinemas1`
    FOREIGN KEY (`cinemas_id`)
    REFERENCES `nesterovich`.`cinemas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nesterovich`.`reserved_tickets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nesterovich`.`reserved_tickets` ;

CREATE TABLE IF NOT EXISTS `nesterovich`.`reserved_tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` INT NOT NULL,
  `cost` DECIMAL(10) NOT NULL,
  `users_id` INT NOT NULL,
  `films_id` INT NOT NULL,
  `cinemas_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservedTickets_users1_idx` (`users_id` ASC),
  INDEX `fk_reservedTickets_films1_idx` (`films_id` ASC),
  INDEX `fk_reservedTickets_cinemas1_idx` (`cinemas_id` ASC),
  CONSTRAINT `fk_reservedTickets_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `nesterovich`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_reservedTickets_films1`
    FOREIGN KEY (`films_id`)
    REFERENCES `nesterovich`.`films` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_reservedTickets_cinemas1`
    FOREIGN KEY (`cinemas_id`)
    REFERENCES `nesterovich`.`cinemas` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `nesterovich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `nesterovich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', NULL, NULL, NULL, 1);
INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@gmail.com', NULL, NULL, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `nesterovich`.`films`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'The Accountant', 'USA', 'action, thriller, drama', 2016, 128);
INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'Self/less', 'USA', 'fantasy, thriller, action', 2015, 112);
INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'Intouchables', 'France', 'drama, comedy, biography', 2011, 112);

COMMIT;


-- -----------------------------------------------------
-- Data for table `nesterovich`.`cinemas`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'Belarus', 'Minsk, st. Romanovskaya Sloboda, 28');
INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'Aurora', 'Minsk, st. Pritytskogo, 23');
INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'October', 'Minsk, pr. Independence, 73');

COMMIT;


-- -----------------------------------------------------
-- Data for table `nesterovich`.`films_cinemas`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 1, 2);
INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 1, 1);
INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 2, 1);
INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 3, 3);
INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 2, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `nesterovich`.`reserved_tickets`
-- -----------------------------------------------------
START TRANSACTION;
USE `nesterovich`;
INSERT INTO `nesterovich`.`reserved_tickets` (`id`, `code`, `cost`, `users_id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 12345678, 5.2, 2, 1, 1);

COMMIT;

