package by.it.nesterovich.jd03_02;

import by.it.nesterovich.jd03_02.beans.*;
import by.it.nesterovich.jd03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    public static void main(String[] args) throws SQLException {
        //Разработайте (либо доработайте) метод сброса и заполнения базы с операциями:
        //Удаления всех таблиц в вашей базе данных (используйте SQL DROP TABLE IF EXISTS имя_таблицы)
        deleteTables();
        //Создания всех таблиц (используйте как пример SQL из файла экспорта)
        createTables();
        //Заполнения таблиц через CRUD операции.
        initTables();
    }

    private static void deleteTables() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP TABLE IF EXISTS reserved_tickets;");
            statement.executeUpdate("DROP TABLE IF EXISTS films_cinemas;");
            statement.executeUpdate("DROP TABLE IF EXISTS users;");
            statement.executeUpdate("DROP TABLE IF EXISTS films;");
            statement.executeUpdate("DROP TABLE IF EXISTS cinemas;");
            statement.executeUpdate("DROP TABLE IF EXISTS roles;");

            System.out.println("Tables delete");
        }
    }

    private static void createTables() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `roles` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `role` VARCHAR(45) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "  ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `users` (\n" +
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
                    "CREATE TABLE IF NOT EXISTS `films` (\n" +
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
                    "CREATE TABLE IF NOT EXISTS `cinemas` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `name` VARCHAR(45) NOT NULL,\n" +
                            "  `address` VARCHAR(45) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "  ENGINE = InnoDB;"
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
                    "CREATE TABLE IF NOT EXISTS `reserved_tickets` (\n" +
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

            System.out.println("Tables create");
        }
    }

    private static void initTables() throws SQLException {
        //roles
        RoleCRUD.create(new Role(0, "admin"));
        RoleCRUD.create(new Role(0, "user"));
        //users
        UserCRUD.create(new User(0, "admin", "password", "admin@it.by", 1));
        UserCRUD.create(new User(0, "user2", "password", "user2@it.by", "Alex", 2));
        UserCRUD.create(new User(0, "user3", "password", "user3@it.by", "Alex4", "Bush", 2));
        UserCRUD.create(new User(0, "user4", "password", "user4@it.by", "Alex7", "Bush8", 12345678, 2));
        //films
        FilmCRUD.create(new Film(0, "name film 1", "country1", "genre1, genre2", 2010, 123));
        FilmCRUD.create(new Film(0, "name film 2", "country3", "genre1", 2008, 113));
        FilmCRUD.create(new Film(0, "name film 3", "country5, country1", "genre1", 2005, 120));
        FilmCRUD.create(new Film(0, "name film 4", "country7", "genre2", 2006, 103));
        //cinemas
        CinemaCRUD.create(new Cinema(0, "name1", "address1"));
        CinemaCRUD.create(new Cinema(0, "name2", "address2"));
        CinemaCRUD.create(new Cinema(0, "name3", "address3"));
        CinemaCRUD.create(new Cinema(0, "name4", "address4"));
        //reserved_tickets
        ReservedTicketCRUD.create(new ReservedTicket(0, 126413, 2.5, 1, 2, 3));
        ReservedTicketCRUD.create(new ReservedTicket(0, 689534, 4.8, 2, 4, 2));
        ReservedTicketCRUD.create(new ReservedTicket(0, 943565, 5.7, 3, 3, 4));
        ReservedTicketCRUD.create(new ReservedTicket(0, 235655, 9.0, 1, 1, 3));
        //films_cinemas
        FilmCinemaCRUD.create(new FilmCinema(0, 1, 3));
        FilmCinemaCRUD.create(new FilmCinema(0, 1, 1));
        FilmCinemaCRUD.create(new FilmCinema(0, 3, 4));
        FilmCinemaCRUD.create(new FilmCinema(0, 2, 3));
        FilmCinemaCRUD.create(new FilmCinema(0, 4, 2));
    }
}
