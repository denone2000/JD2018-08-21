-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Role` (
  `Role_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`Role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agents` (
  `Agents_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `Role_id` INT NOT NULL,
  PRIMARY KEY (`Agents_id`),
  INDEX `fk_Users_Role_idx` (`Role_id` ASC),
  CONSTRAINT `fk_Users_Role`
    FOREIGN KEY (`Role_id`)
    REFERENCES `mydb`.`Role` (`Role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(4500) NULL,
  `type` VARCHAR(200) NULL,
  `amount_agents` INT NULL,
  `address` VARCHAR(100) NULL,
  `Agents_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Company_Agents1_idx` (`Agents_id` ASC),
  CONSTRAINT `fk_Company_Agents1`
    FOREIGN KEY (`Agents_id`)
    REFERENCES `mydb`.`Agents` (`Agents_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `mydb`.`Role`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Role` (`Role_id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `mydb`.`Role` (`Role_id`, `role`) VALUES (DEFAULT, 'admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Agents`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Agents` (`Agents_id`, `name`, `address`, `Role_id`) VALUES (1, 'vera', 'ostoshitskaia', 1);
INSERT INTO `mydb`.`Agents` (`Agents_id`, `name`, `address`, `Role_id`) VALUES (2, 'artem', 'gintovta', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Company`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, 'TASK', 'insurance', 3468, 'nezavisimosti', 1);
INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, 'Belneftestrach', 'insurance', 579, 'masherova', 2);
INSERT INTO `mydb`.`Company` (`id`, `name`, `type`, `amount_agents`, `address`, `Agents_id`) VALUES (DEFAULT, NULL, NULL, NULL, NULL, 3);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
