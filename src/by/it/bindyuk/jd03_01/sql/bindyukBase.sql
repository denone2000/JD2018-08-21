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
-- Table `bindyuk`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bindyuk`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transport` VARCHAR(45) NULL,
  `placefrom` VARCHAR(45) NULL,
  `placeto` VARCHAR(45) NULL,
  `date` INT NULL,
  `month` INT NULL,
  `year` INT NULL,
  `passport series` VARCHAR(45) NULL,
  `passport id` INT NULL,
  `bancard number` VARCHAR(40) NULL,
  `cid` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_tickets_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `bindyuk`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


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
INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 1);
INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bindyuk`.`tickets`
-- -----------------------------------------------------
START TRANSACTION;
USE `bindyuk`;
INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `placefrom`, `placeto`, `date`, `month`, `year`, `passport series`, `passport id`, `bancard number`, `cid`, `users_id`) VALUES (DEFAULT, 'train', 'Minsk', 'Gomel', 21, 12, 2018, 'MP', 2726171, '2018201920202021', 453, 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
