package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTables {

    static void addTables(){
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `galushka` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `galushka` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `galushka`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `galushka`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `galushka`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `galushka`.`cars` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Mark` VARCHAR(45) NULL,\n" +
                    "  `Model` VARCHAR(45) NULL,\n" +
                    "  `Color` VARCHAR(45) NULL,\n" +
                    "  `Engine capacity` DOUBLE NULL,\n" +
                    "  `Release date` DATE NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_cars_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_cars_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `galushka`.`users` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `galushka`.`orders` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Passport id` VARCHAR(14) NULL,\n" +
                    "  `Order date` DATE NULL,\n" +
                    "  `Return date` DATE NULL,\n" +
                    "  `Surname` VARCHAR(45) NULL,\n" +
                    "  `Name` VARCHAR(45) NULL,\n" +
                    "  `Middle name` VARCHAR(45) NULL,\n" +
                    "  `Address` VARCHAR(45) NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `galushka`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
