package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void initialization() {

//        Driver driver = new FabricMySQLDriver();
//        DriverManager.registerDriver(driver);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
        ) {
//создаем базу данных
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bindyuk` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `bindyuk` DEFAULT CHARACTER SET utf8 ;");

//создаем таблицу Роли
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

//создаем таблицу Юзеров
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `bindyuk`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");

//создаем таблицу Билетов

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bindyuk`.`tickets` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `transport` VARCHAR(45) NULL,\n" +
                    "  `placefrom` VARCHAR(45) NULL,\n" +
                    "  `placeto` VARCHAR(45) NULL,\n" +
                    "  `date` INT NULL,\n" +
                    "  `month` INT NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `passport series` VARCHAR(45) NULL,\n" +
                    "  `passport id` INT NULL,\n" +
                    "  `bancard number` VARCHAR(40) NULL,\n" +
                    "  `cid` INT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_tickets_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_tickets_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `bindyuk`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            //наполняем таблицы

            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `bindyuk`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `placefrom`, `placeto`, `date`, `month`, `year`, `passport series`, `passport id`," +
                    " `bancard number`, `cid`, `users_id`) VALUES (DEFAULT, 'train', 'Minsk', 'Gomel', 21, 12, 2018, 'MP', 2726171, '2018201920202021', 453, 2);\n");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
