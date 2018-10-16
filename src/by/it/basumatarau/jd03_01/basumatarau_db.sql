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
-- Table `basumatarau`.`Venues`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basumatarau`.`Venues` ;

CREATE TABLE IF NOT EXISTS `basumatarau`.`Venues` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `TypeTags` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Description` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Place` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `OpeningDeteTime` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `Fee` FLOAT NOT NULL,
  `users_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Venues_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_Venues_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `basumatarau`.`Users` (`ID`)
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
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'user1', '', 'user1@gmail.com', 2);
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'user2', '', 'user2@gmail.com', 2);
INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'admin', '', 'admin@gmail.com', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `basumatarau`.`Venues`
-- -----------------------------------------------------
START TRANSACTION;
USE `basumatarau`;
INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `TypeTags`, `Description`, `Place`, `OpeningDeteTime`, `Fee`, `users_ID`) VALUES (DEFAULT, 'Some venue', 'some tags', 'some description', 'some place', '20:50', 6.0, 2);

COMMIT;

