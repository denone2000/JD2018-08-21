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
CREATE SCHEMA IF NOT EXISTS `basumatarau` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
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
AUTO_INCREMENT = 1
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
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  INDEX `fk_users_Roles_idx` (`Roles_ID` ASC),
  CONSTRAINT `fk_users_Roles`
    FOREIGN KEY (`Roles_ID`)
    REFERENCES `basumatarau`.`Roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `basumatarau`.`Places`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Places` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Places` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `basumatarau`.`Venues`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Venues` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Venues` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Description` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `OpeningDeteTime` TIMESTAMP NOT NULL,
  `Fee` FLOAT NOT NULL,
  `Users_ID` INT(11) NOT NULL,
  `Places_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Venues_Users1_idx` (`Users_ID` ASC),
  INDEX `fk_Venues_Places1_idx` (`Places_ID` ASC),
  CONSTRAINT `fk_Venues_users1`
    FOREIGN KEY (`Users_ID`)
    REFERENCES `basumatarau`.`Users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Venues_Places1`
    FOREIGN KEY (`Places_ID`)
    REFERENCES `basumatarau`.`Places` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `basumatarau`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `basumatarau`;
INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');
INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'user');
INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `basumatarau`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `basumatarau`;
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'administrator', 'admin', 'adm@gmail.com', 1);
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'some user', 'user123', 'usr1@gmail.com', 2);
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'another user', 'user321', 'usr2@gmail.com', 2);
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'some guest', 'guest22', 'gst0@gmail.com', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `basumatarau`.`Places`
-- -----------------------------------------------------
START TRANSACTION;
USE `basumatarau`;
INSERT INTO `basumatarau`.`Places` (`ID`, `Name`, `Address`) VALUES (DEFAULT, 'Museum of Modern Belarusian Statehood', 'vulica Kirava 43, Minsk');
INSERT INTO `basumatarau`.`Places` (`ID`, `Name`, `Address`) VALUES (DEFAULT, 'Akademkniga book shop', 'Praspyekt Nyezalyezhnastsi 72, Minsk');

COMMIT;


-- -----------------------------------------------------
-- Data for table `basumatarau`.`Venues`
-- -----------------------------------------------------
START TRANSACTION;
USE `basumatarau`;
INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) VALUES (DEFAULT, 'Wine-tasting', 'alcoholic party', 0, 10.0, 3, 1);
INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) VALUES (DEFAULT, 'Book presentation', 'nonalcoholic party', 0, 5.5, 2, 2);

COMMIT;

