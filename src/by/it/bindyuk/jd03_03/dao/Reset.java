package by.it.bindyuk.jd03_03.dao;

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
             Statement statement = connection.createStatement()
        ) {


            //==========================================================================================================
            //создаем базу данных
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bindyuk` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `bindyuk` DEFAULT CHARACTER SET utf8 ;");

            //==========================================================================================================
            //создаем таблицу Роли
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //создаем таблицу Юзеров
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `passport series` VARCHAR(45) NULL,\n" +
                    "  `passport id` INT NULL,\n" +
                    "  `bancard number` VARCHAR(45) NULL,\n" +
                    "  `cid` INT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `bindyuk`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //создаем таблицу машрутов
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`routes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //создаем таблицу билетов
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`tickets` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `transport` VARCHAR(45) NULL,\n" +
                    "  `routes_id from` INT NOT NULL,\n" +
                    "  `routes_id to` INT NOT NULL,\n" +
                    "  `data` TIMESTAMP NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_tickets_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_tickets_routes1_idx` (`routes_id from` ASC),\n" +
                    "  INDEX `fk_tickets_routes2_idx` (`routes_id to` ASC),\n" +
                    "  CONSTRAINT `fk_tickets_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `bindyuk`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_tickets_routes1`\n" +
                    "    FOREIGN KEY (`routes_id from`)\n" +
                    "    REFERENCES `bindyuk`.`routes` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_tickets_routes2`\n" +
                    "    FOREIGN KEY (`routes_id to`)\n" +
                    "    REFERENCES `bindyuk`.`routes` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //наполняем таблицы

            //роли
            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            //==========================================================================================================
            //юзеры
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`," +
                    " `passport series`, `passport id`, `bancard number`, `cid`, `roles_id`) " +
                    "VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 'NULL', 0, '0', 0, 1);");
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`," +
                    " `passport series`, `passport id`, `bancard number`, `cid`, `roles_id`)" +
                    "VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 'MP', 2560012, '0001 0002 0003 0004', 563, 2);");

            //==========================================================================================================
            //города
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Minsk');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Grodno');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Brest');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Gomel');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Mogilev');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Vitsiebsk');");

            //==========================================================================================================
            //билеты
            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `routes_id from`, `routes_id to`, `data`, `users_id`)" +
                    " VALUES (DEFAULT, 'train', 1, 2, '1540816800', 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
