package by.it.artemliashkov.jd03_02;
import by.it.artemliashkov.jd03_02.beans.Role;
import by.it.artemliashkov.jd03_02.beans.Company;
import by.it.artemliashkov.jd03_02.beans.Agent;
import by.it.artemliashkov.jd03_02.RoleCRUD;
import by.it.artemliashkov.jd03_02.AgentCRUD;
import by.it.artemliashkov.jd03_02.CompanyCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    public static void main(String[] args) throws SQLException {
        //reset();
        initializing();
        initTables();
    }

    static void reset() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS Role;");
            statement.executeUpdate("DROP TABLE IF EXISTS `mydb`.`Agents` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `mydb`.`Company` ;");
        }
    }

    static void initializing() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydb`.`Role` (\n" +
                    "  `Role_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`Role_id`))\n" +
                    "ENGINE = InnoDB;\n");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydb`.`Agents` (\n" +
                    "  `Agents_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  `Role_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`Agents_id`),\n" +
                    "  INDEX `fk_Users_Role_idx` (`Role_id` ASC),\n" +
                    "  CONSTRAINT `fk_Users_Role`\n" +
                    "    FOREIGN KEY (`Role_id`)\n" +
                    "    REFERENCES `mydb`.`Role` (`Role_id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;\n");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mydb`.`Company` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(4500) NULL,\n" +
                    "  `type` VARCHAR(200) NULL,\n" +
                    "  `amount_agents` INT NULL,\n" +
                    "  `address` VARCHAR(100) NULL,\n" +
                    "  `Agents_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Company_Agents1_idx` (`Agents_id` ASC),\n" +
                    "  CONSTRAINT `fk_Company_Agents1`\n" +
                    "    FOREIGN KEY (`Agents_id`)\n" +
                    "    REFERENCES `mydb`.`Agents` (`Agents_id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;\n");

        }
    }

    private static void initTables() throws SQLException {
        RoleCRUD.create(new Role(0,"admin"));
        RoleCRUD.create(new Role(0,"user"));

        AgentCRUD.create(new Agent(0,"artem","ostroshitstskaia",6));
        AgentCRUD.create(new Agent(0,"vera","gintovta",4));
        AgentCRUD.create(new Agent(0,"galina","nikiforova",4));
        AgentCRUD.create(new Agent(0,"sasha","gorodetskaia",5));
        CompanyCRUD.create(new Company(0,"TASK","insurance",  666,"ostrosh",6));
        CompanyCRUD.create(new Company(0, "TASK2", "insurance", 345,"gint",113));
    }
}
