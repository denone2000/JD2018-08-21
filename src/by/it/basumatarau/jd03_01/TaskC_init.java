package by.it.basumatarau.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC_init {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }


        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `basumatarau` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `basumatarau` DEFAULT CHARACTER SET utf8mb4 ;");
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
                    "  INDEX `fk_users_Roles_idx` (`Roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_Roles`\n" +
                    "    FOREIGN KEY (`Roles_ID`)\n" +
                    "    REFERENCES `basumatarau`.`Roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8mb4;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `basumatarau`.`Venues` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `TypeTags` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Description` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Place` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `OpeningDeteTime` VARCHAR(100) COLLATE 'utf8mb4_unicode_ci' NOT NULL,\n" +
                    "  `Fee` FLOAT NOT NULL,\n" +
                    "  `users_ID` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_Venues_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_Venues_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `basumatarau`.`Users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8mb4;");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Roles` (`ID`, `Role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'user1', '', 'user1@gmail.com', 2);\n");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'user2', '', 'user2@gmail.com', 2);\n");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Users` (`ID`, `Login`, `Password`, `Email`, `Roles_ID`) VALUES (DEFAULT, 'admin', '', 'admin@gmail.com', 1);\n");
            statement.executeUpdate("INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `TypeTags`, `Description`, `Place`, `OpeningDeteTime`, `Fee`, `users_ID`) VALUES (DEFAULT, 'Some venue', 'some tags', 'some description', 'some place', '20:50', 6.0, 2);\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
