package by.it.voinilo.jd03.jd03_01.sql;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class C_INIT implements CN {
    public static void main(String[] args) throws SQLException {
        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `voinilo` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `voinilo` DEFAULT CHARACTER SET utf8 ;\n" +
                    "USE `voinilo` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `voinilo`.`roles` ;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS `voinilo`.`roles` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `voinilo`.`roleparam` ;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS `voinilo`.`roleparam` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `password` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `email` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `roles_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_roles_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_roles_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `voinilo`.`roles` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `voinilo`.`ads` ;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS `voinilo`.`ads` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `address` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `price` INT(11) NOT NULL,\n" +
                    "  `condition` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,\n" +
                    "  `number` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,\n" +
                    "  `roles_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_roles1_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `voinilo`.`roleparam` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8\n" +
                    "COLLATE = utf8_bin;\n" +
                    "\n" +
                    "\n" +
                    "SET SQL_MODE=@OLD_SQL_MODE;\n" +
                    "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;\n" +
                    "SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;\n");
         statement.executeUpdate("START TRANSACTION;\n" +
                 "USE `voinilo`;\n" +
                 "INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n" +
                 "INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');\n" +
                 "INSERT INTO `voinilo`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');\n" +
                 "\n" +
                 "COMMIT;\n");
         statement.executeUpdate("START TRANSACTION;\n" +
                 "USE `voinilo`;\n" +
                 "INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);\n" +
                 "INSERT INTO `voinilo`.`roleparam` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);\n" +
                 "\n" +
                 "COMMIT;\n");
         statement.executeUpdate("START TRANSACTION;\n" +
                 "USE `voinilo`;\n" +
                 "INSERT INTO `voinilo`.`ads` (`id`, `description`, `address`, `name`, `price`, `condition`, `number`, `roles_id`) VALUES (DEFAULT, 'bla-bla-bla', 'центральная,2,кв 33', 'galaxy s6', 50, 'good', '1', 2);\n" +
                 "\n" +
                 "COMMIT;");
        }
    }
}
