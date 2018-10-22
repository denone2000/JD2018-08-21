-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bindyuk
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bindyuk` ;

-- -----------------------------------------------------
-- Schema bindyuk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bindyuk` DEFAULT CHARACTER SET utf8 ;
USE `bindyuk` ;

-- -----------------------------------------------------
-- Table `bindyuk`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bindyuk`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bindyuk`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bindyuk`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `passport series` VARCHAR(45) NULL,
  `passport id` INT NULL,
  `bancard number` VARCHAR(45) NULL,
  `cid` INT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `bindyuk`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bindyuk`.`routes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bindyuk`.`routes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bindyuk`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bindyuk`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transport` VARCHAR(45) NULL,
  `routes_id from` INT NOT NULL,
  `routes_id to` INT NOT NULL,
  `data` INT NULL,
  `month` INT NULL,
  `year` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_users1_idx` (`users_id` ASC),
  INDEX `fk_tickets_routes1_idx` (`routes_id from` ASC),
  INDEX `fk_tickets_routes2_idx` (`routes_id to` ASC),
  CONSTRAINT `fk_tickets_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `bindyuk`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tickets_routes1`
    FOREIGN KEY (`routes_id from`)
    REFERENCES `bindyuk`.`routes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tickets_routes2`
    FOREIGN KEY (`routes_id to`)
    REFERENCES `bindyuk`.`routes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bindyuk`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `bindyuk`;
INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bindyuk`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `bindyuk`;
INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `passport series`, `passport id`, `bancard number`, `cid`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 'NULL', 0, '0', 0, 1);
INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `passport series`, `passport id`, `bancard number`, `cid`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 'MP', 2560012, '0001 0002 0003 0004', 563, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bindyuk`.`routes`
-- -----------------------------------------------------
START TRANSACTION;
USE `bindyuk`;
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Minsk');
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Grodno');
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Brest');
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Gomel');
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Mogilev');
INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Vitsiebsk');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bindyuk`.`tickets`
-- -----------------------------------------------------
START TRANSACTION;
USE `bindyuk`;
INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `routes_id from`, `routes_id to`, `data`, `month`, `year`, `users_id`) VALUES (DEFAULT, 'train', 1, 2, 21, 12, 2018, 2);

COMMIT;

