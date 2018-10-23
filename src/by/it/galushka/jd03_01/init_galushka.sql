-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema galushka
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `galushka` ;

-- -----------------------------------------------------
-- Schema galushka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `galushka` DEFAULT CHARACTER SET utf8 ;
USE `galushka` ;

-- -----------------------------------------------------
-- Table `galushka`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `galushka`.`roles` ;

CREATE TABLE IF NOT EXISTS `galushka`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galushka`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `galushka`.`users` ;

CREATE TABLE IF NOT EXISTS `galushka`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `galushka`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galushka`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `galushka`.`cars` ;

CREATE TABLE IF NOT EXISTS `galushka`.`cars` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Mark` VARCHAR(45) NULL,
  `Model` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Engine capacity` DOUBLE NULL,
  `Release date` DATE NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_cars_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_cars_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `galushka`.`users` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `galushka`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `galushka`.`orders` ;

CREATE TABLE IF NOT EXISTS `galushka`.`orders` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Passport ID` VARCHAR(14) NULL,
  `Order date` DATE NULL,
  `Return date` DATE NULL,
  `Surname` VARCHAR(45) NULL,
  `Name` VARCHAR(45) NULL,
  `Middle name` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_orders_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `galushka`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `galushka`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `galushka`;
INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `galushka`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `galushka`;
INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `galushka`.`cars`
-- -----------------------------------------------------
START TRANSACTION;
USE `galushka`;
INSERT INTO `galushka`.`cars` (`ID`, `Mark`, `Model`, `Color`, `Engine capacity`, `Release date`, `users_ID`) VALUES (DEFAULT, 'Audi', 'A4', 'Grey', 2.0, '2018/01/01', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `galushka`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `galushka`;
INSERT INTO `galushka`.`orders` (`ID`, `Passport ID`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '123456789oiuyt', '2018.01.01', '2018/11/01', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);

COMMIT;

