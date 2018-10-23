-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema voinilo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `voinilo` ;

-- -----------------------------------------------------
-- Schema voinilo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `voinilo` DEFAULT CHARACTER SET utf8 ;
USE `voinilo` ;

-- -----------------------------------------------------
-- Table `voinilo`.`roles`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `voinilo`.`roles` ;

CREATE TABLE IF NOT EXISTS `voinilo`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `voinilo`.`roleparam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voinilo`.`roleparam` ;

CREATE TABLE IF NOT EXISTS `voinilo`.`roleparam` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `roles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_roles_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_roles_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `voinilo`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `voinilo`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voinilo`.`ads` ;

CREATE TABLE IF NOT EXISTS `voinilo`.`ads` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `address` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `price` INT(11) NOT NULL,
  `condition` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `number` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `roles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_ads_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `voinilo`.`roleparam` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `voinilo`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `voinilo`;
INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `voinilo`.`roleparam`
-- -----------------------------------------------------
START TRANSACTION;
USE `voinilo`;
INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `voinilo`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `voinilo`;
INSERT INTO `voinilo`.`ads` (`id`, `description`, `address`, `name`, `price`, `condition`, `number`, `roles_id`) VALUES (DEFAULT, 'bla-bla-bla', 'центральная,2,кв 33', 'galaxy s6', 50, 'good', '1', 2);

COMMIT;

