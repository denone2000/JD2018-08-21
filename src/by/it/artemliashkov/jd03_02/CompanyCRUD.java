package by.it.artemliashkov.jd03_02;

import by.it.artemliashkov.jd03_02.beans.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyCRUD {

    static boolean create(Company company) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sqlQuery = String.format("INSERT INTO `Company`(`name`, `type`,`amount_agents`,`address`, `Agents_id`) " +
                            "VALUES ('%s','%s','%d','%s','%d')",
                    company.getName(),
                    company.getType(),
                    company.getAmountAgents(),
                    company.getAddress(),
                    company.getId()
            );
            if (statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    company.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    static Company read(Long CompanyID) throws SQLException {
        Company company = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sqlQuery = String.format("SELECT * FROM `Company` WHERE `id`=%d",
                    CompanyID
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                company = new Company(resultSet.getLong("Agents_id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getInt("amount_agents"),
                        resultSet.getString("address"),
                        resultSet.getInt("id"));
            }
        }
        return company;
    }

    static boolean update(Company company) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlQuery = String.format(
                    "UPDATE `Company` SET `Name`='%s'," +
                            "`Type`='%s'," +
                            "`Amount_agents`='%s'," +
                            "`Agents_ID`='%s' " +
                            "WHERE `id`=%s",
                    company.getName(),
                    company.getType(),
                    company.getAmountAgents(),
                    company.getAddress(),
                    company.getAgents_ID(),
                    company.getId());
            return statement.executeUpdate(sqlQuery) == 1;
        }
    }

    static boolean delete(Company company) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sqlQuery = String.format("DELETE FROM `Company` WHERE `id`=%d",
                    company.getId());
            return statement.executeUpdate(sqlQuery) == 1;
        }
    }

    public static void main(String[] args) throws SQLException {

        Company u = new Company(6,"TASK","insurance",  666,"ostrosh",6);
        create(u);
        System.out.println(read(u.getId()));
        u.setName("qwerty");
        update(u);
        System.out.println(read(u.getId()));
        delete(u);

    }
}
