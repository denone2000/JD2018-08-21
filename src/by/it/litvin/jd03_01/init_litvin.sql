-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema litvin
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `litvin` ;

-- -----------------------------------------------------
-- Schema litvin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `litvin` DEFAULT CHARACTER SET utf8 ;
USE `litvin` ;

-- -----------------------------------------------------
-- Table `litvin`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `litvin`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `litvin`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `litvin`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `litvin`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `litvin`.`form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `litvin`.`form` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(500) NULL,
  `description` VARCHAR(5000) NULL,
  `age` INT NULL,
  `information` VARCHAR(5000) NULL,
  `aim` VARCHAR(5000) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_form_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_form_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `litvin`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `litvin`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `litvin`;
INSERT INTO `litvin`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `litvin`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `litvin`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `litvin`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `litvin`;
INSERT INTO `litvin`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `litvin`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `litvin`.`form`
-- -----------------------------------------------------
START TRANSACTION;
USE `litvin`;
INSERT INTO `litvin`.`form` (`id`, `address`, `description`, `age`, `information`, `aim`, `users_id`) VALUES (DEFAULT, 'Minsk', 'beautiful', 18, 'student', 'relationship', 2);

COMMIT;

