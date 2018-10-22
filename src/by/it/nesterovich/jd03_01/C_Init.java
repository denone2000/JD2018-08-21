package by.it.nesterovich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

class C_Init {

    static void cInit() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN_DB.URL_DB, CN_DB.USER_DB, CN_DB.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(
                    "DROP SCHEMA IF EXISTS `nesterovich` ;"
            );
            statement.executeUpdate(
                    "CREATE SCHEMA IF NOT EXISTS `nesterovich` DEFAULT CHARACTER SET utf8 ;"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`roles` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`roles` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `role` VARCHAR(45) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "  ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`users` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`users` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `login` VARCHAR(60) NOT NULL,\n" +
                            "  `password` VARCHAR(60) NOT NULL,\n" +
                            "  `email` VARCHAR(60) NOT NULL,\n" +
                            "  `firstName` VARCHAR(50) NULL,\n" +
                            "  `lastName` VARCHAR(50) NULL,\n" +
                            "  `phoneNumber` INT NULL,\n" +
                            "  `roles_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                            "  CONSTRAINT `fk_users_roles`\n" +
                            "  FOREIGN KEY (`roles_id`)\n" +
                            "  REFERENCES `nesterovich`.`roles` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT)\n" +
                            "  ENGINE = InnoDB;\n"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`films` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`films` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `name` VARCHAR(45) NOT NULL,\n" +
                            "  `country` VARCHAR(60) NOT NULL,\n" +
                            "  `genre` VARCHAR(60) NOT NULL,\n" +
                            "  `yearOfIssue` INT NOT NULL,\n" +
                            "  `duration` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "  ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`cinemas` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`cinemas` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `name` VARCHAR(45) NOT NULL,\n" +
                            "  `address` VARCHAR(45) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "  ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`films_cinemas` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`films_cinemas` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `films_id` INT NOT NULL,\n" +
                            "  `cinemas_id` INT NOT NULL,\n" +
                            "  INDEX `fk_films_cinemas_films1_idx` (`films_id` ASC),\n" +
                            "  INDEX `fk_films_cinemas_cinemas1_idx` (`cinemas_id` ASC),\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  CONSTRAINT `fk_films_cinemas_films1`\n" +
                            "    FOREIGN KEY (`films_id`)\n" +
                            "    REFERENCES `nesterovich`.`films` (`id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE,\n" +
                            "  CONSTRAINT `fk_films_cinemas_cinemas1`\n" +
                            "    FOREIGN KEY (`cinemas_id`)\n" +
                            "    REFERENCES `nesterovich`.`cinemas` (`id`)\n" +
                            "    ON DELETE NO ACTION\n" +
                            "    ON UPDATE NO ACTION)\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS `nesterovich`.`reserved_tickets` ;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `nesterovich`.`reserved_tickets` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `code` INT NOT NULL,\n" +
                            "  `cost` DECIMAL(10) NULL,\n" +
                            "  `users_id` INT NOT NULL,\n" +
                            "  `films_id` INT NOT NULL,\n" +
                            "  `cinemas_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_reservedTickets_users1_idx` (`users_id` ASC),\n" +
                            "  INDEX `fk_reservedTickets_films1_idx` (`films_id` ASC),\n" +
                            "  INDEX `fk_reservedTickets_cinemas1_idx` (`cinemas_id` ASC),\n" +
                            "  CONSTRAINT `fk_reservedTickets_users1`\n" +
                            "  FOREIGN KEY (`users_id`)\n" +
                            "  REFERENCES `nesterovich`.`users` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT,\n" +
                            "  CONSTRAINT `fk_reservedTickets_films1`\n" +
                            "  FOREIGN KEY (`films_id`)\n" +
                            "  REFERENCES `nesterovich`.`films` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT,\n" +
                            "  CONSTRAINT `fk_reservedTickets_cinemas1`\n" +
                            "  FOREIGN KEY (`cinemas_id`)\n" +
                            "  REFERENCES `nesterovich`.`cinemas` (`id`)\n" +
                            "    ON DELETE RESTRICT\n" +
                            "    ON UPDATE RESTRICT)\n" +
                            "  ENGINE = InnoDB;"
            );
            //INSERT
            statement.executeUpdate("INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `nesterovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");

            statement.executeUpdate("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', NULL, NULL, NULL, 1);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`users` (`id`, `login`, `password`, `email`, `firstName`, `lastName`, `phoneNumber`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@gmail.com', NULL, NULL, NULL, 2);");

            statement.executeUpdate("INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'The Accountant', 'USA', 'action, thriller, drama', 2016, 128);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'Self/less', 'USA', 'fantasy, thriller, action', 2015, 112);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films` (`id`, `name`, `country`, `genre`, `yearOfIssue`, `duration`) VALUES (DEFAULT, 'Intouchables', 'France', 'drama, comedy, biography', 2011, 112);");

            statement.executeUpdate("INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'Belarus', 'Minsk, st. Romanovskaya Sloboda, 28');");
            statement.executeUpdate("INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'Aurora', 'Minsk, st. Pritytskogo, 23');");
            statement.executeUpdate("INSERT INTO `nesterovich`.`cinemas` (`id`, `name`, `address`) VALUES (DEFAULT, 'October', 'Minsk, pr. Independence, 73');");

            statement.executeUpdate("INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 1, 2);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 1, 1);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 2, 1);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 3, 3);");
            statement.executeUpdate("INSERT INTO `nesterovich`.`films_cinemas` (`id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 2, 3);");

            statement.executeUpdate("INSERT INTO `nesterovich`.`reserved_tickets` (`id`, `code`, `cost`, `users_id`, `films_id`, `cinemas_id`) VALUES (DEFAULT, 12345678, 5.2, 2, 1, 1);");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
