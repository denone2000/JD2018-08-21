package by.it.basumatarau.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_init {
    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";

    static void createDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `basumatarau` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `basumatarau` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `basumatarau`.`Roles` (\n" +
                            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Role` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`))\n" +
                            "ENGINE = InnoDB\n" +
                            "AUTO_INCREMENT = 1\n" +
                            "DEFAULT CHARACTER SET = utf8mb4;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `basumatarau`.`Users` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Password` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Email` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Roles_ID` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),\n" +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),\n" +
                    "  INDEX `fk_users_Roles_idx` (`Roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_Roles`\n" +
                    "    FOREIGN KEY (`Roles_ID`)\n" +
                    "    REFERENCES `basumatarau`.`Roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8mb4;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `basumatarau`.`Places` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(45) NOT NULL,\n" +
                    "  `Address` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `basumatarau`.`Venues` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Description` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `OpeningDeteTime` TIMESTAMP NOT NULL,\n" +
                    "  `Fee` FLOAT NOT NULL,\n" +
                    "  `Users_ID` INT(11) NOT NULL,\n" +
                    "  `Places_ID` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_Venues_Users1_idx` (`Users_ID` ASC),\n" +
                    "  INDEX `fk_Venues_Places1_idx` (`Places_ID` ASC),\n" +
                    "  CONSTRAINT `fk_Venues_users1`\n" +
                    "    FOREIGN KEY (`Users_ID`)\n" +
                    "    REFERENCES `basumatarau`.`Users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_Venues_Places1`\n" +
                    "    FOREIGN KEY (`Places_ID`)\n" +
                    "    REFERENCES `basumatarau`.`Places` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8mb4;");

            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'administrator', 'admin', 'adm@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'some user', 'user123', 'usr1@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'another user', 'user321', 'usr2@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'some guest', 'guest22', 'gst0@gmail.com', 3);");

            statement.executeUpdate("INSERT INTO `basumatarau`.`Places` (`ID`, `Name`, `Address`) VALUES (DEFAULT, 'Museum of Modern Belarusian Statehood', 'vulica Kirava 43, Minsk');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Places` (`ID`, `Name`, `Address`) VALUES (DEFAULT, 'Akademkniga book shop', 'Praspyekt Nyezalyezhnastsi 72, Minsk');");

            statement.executeUpdate("INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) VALUES (DEFAULT, 'Wine-tasting', 'alcoholic party', 0, 10.0, 3, 1);");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) VALUES (DEFAULT, 'Book presentation', 'nonalcoholic party', 0, 5.5, 2, 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
