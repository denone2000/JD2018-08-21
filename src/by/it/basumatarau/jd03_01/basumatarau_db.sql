-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema basumatarau
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `basumatarau` ;

-- -----------------------------------------------------
-- Schema basumatarau
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basumatarau` DEFAULT CHARACTER SET utf8mb4 ;
USE `basumatarau` ;

-- -----------------------------------------------------
-- Table `basumatarau`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Roles` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `basumatarau`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Users` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Password` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Email` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Roles_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_Roles_idx` (`Roles_ID` ASC),
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  CONSTRAINT `fk_users_Roles`
    FOREIGN KEY (`Roles_ID`)
    REFERENCES `basumatarau`.`Roles` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `basumatarau`.`Venues`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Venues` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Venues` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Description` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Place` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `OpeningDeteTime` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Fee` FLOAT NOT NULL,
  `Users_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Venues_Users1_idx` (`Users_ID` ASC),
  CONSTRAINT `fk_Venues_users1`
    FOREIGN KEY (`Users_ID`)
    REFERENCES `basumatarau`.`Users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
