package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC_Init {

    public static void init() {
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
                    "  `Release date` VARCHAR(45) NULL,\n" +
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
                    "  `Order date` VARCHAR(45) NULL,\n" +
                    "  `Return date` VARCHAR(45) NULL,\n" +
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
            statement.executeUpdate("INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `galushka`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');");
            statement.executeUpdate("INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);");
            statement.executeUpdate("INSERT INTO `galushka`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);");
            statement.executeUpdate("INSERT INTO `galushka`.`cars` (`ID`, `Mark`, `Model`, `Color`, `Engine capacity`, `Release date`, `users_ID`) VALUES (DEFAULT, 'Audi', 'A4', 'Grey', 2.0, '2018/01/01', 1);");
            statement.executeUpdate("INSERT INTO `galushka`.`orders` (`ID`, `Passport id`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '123456789oiuyt', '2018.01.01', '2018/11/01', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);");
            System.out.println("--->Init done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
