package by.it.akhmelev.jd03_03.beansdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {

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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `akhmelev`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(5000) NULL,\n" +
                    "  `address` VARCHAR(200) NULL,\n" +
                    "  `rooms` INT NULL,\n" +
                    "  `floor` INT NULL,\n" +
                    "  `floors` INT NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `area` DECIMAL NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `akhmelev`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `rooms`, `floor`, `floors`, `price`, `area`, `users_id`) VALUES (DEFAULT, 'good app', 'Minsk Lenina 2 2', 2, 3, 6, 88888, 55, 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
