package by.it.bindyuk.jd03_02;

import by.it.bindyuk.jd03_02.beans.Role;
import by.it.bindyuk.jd03_02.beans.Route;
import by.it.bindyuk.jd03_02.beans.Ticket;
import by.it.bindyuk.jd03_02.beans.User;
import by.it.bindyuk.jd03_02.crud.RoleCRUD;
import by.it.bindyuk.jd03_02.crud.RouteCRUD;
import by.it.bindyuk.jd03_02.crud.TicketCRUD;
import by.it.bindyuk.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    //==================================================================================================================
    //метод для удаления всех таблиц
    static void reset() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`tickets` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`routes` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bindyuk`.`roles` ;");
        }
    }

    //==================================================================================================================
    //создание таблиц по очереди
    static void initializing() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            //==========================================================================================================
            //таблица роли
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //таблица пользователей
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
            //таблица маршрутов
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`routes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            //==========================================================================================================
            //таблтица билетов
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`tickets` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `transport` VARCHAR(45) NULL,\n" +
                    "  `routes_id from` INT NOT NULL,\n" +
                    "  `routes_id to` INT NOT NULL,\n" +
                    "  `data` INT NULL,\n" +
                    "  `month` INT NULL,\n" +
                    "  `year` INT NULL,\n" +
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
        }
    }

    //==================================================================================================================
    //новая роль
    static void addRole(String role) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            Role roleNew = new Role(0, role);
            RoleCRUD.create(roleNew);
        }
    }

    //==================================================================================================================
    //новый пользователь
    static void addUser(String login, String password, String email, String passpostSeries,
                        int passportId, String bancardNumber, int cid, long rolesId) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            User user = new User(0, login, password, email, passpostSeries, passportId, bancardNumber, cid, rolesId);
            UserCRUD.create(user);
        }
    }

    //==================================================================================================================
    //новый билет
    static void addTicket(String transport, long routesIdFrom, long routesIdTo,
                          int data, int month, int year, long usersId) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            Ticket ticket = new Ticket(0, transport, routesIdFrom, routesIdTo, data, month, year, usersId);
            TicketCRUD.create(ticket);
        }
    }

    //==================================================================================================================
    //новый город в маршрутах
    static void addRoute(String city) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            Route route = new Route(0, city);
            RouteCRUD.create(route);
        }
    }
}

