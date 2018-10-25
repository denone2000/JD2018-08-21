package by.it.artemliashkov.jd03_03.dao;

import by.it.artemliashkov.jd03_03.beans.Company;
import by.it.artemliashkov.jd03_03.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends AbstractDao implements InterfaceDao<Company> {

    @Override
    public boolean create(Company company) throws SQLException {
        String sql = String.format(
                "INSERT INTO `Company`(`name`, `type`,`amount_agents`,`address`, `Agents_id`) " +
                        "VALUES ('%s','%s','%d','%s','%d')",
                company.getName(),
                company.getType(),
                company.getAmountAgents(),
                company.getAddress(),
                company.getAgents_ID()
        );
        company.setId(executeUpdate(sql));
        return (company.getAgents_ID() > 0);
    }

    @Override
    public Company read(int id) throws SQLException {
        List<Company> cinemas = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (cinemas.size() > 0) ? cinemas.get(0) : null;
    }

    @Override
    public boolean update(Company company) throws SQLException {
        String sql = String.format(
                "UPDATE `Company` SET `Name`='%s'," +
                        "`Type`='%s'," +
                        "`Amount_agents`='%s'," +
                        "`Agents_id`='%d' " +
                        "WHERE `id`=%s",
                company.getName(),
                company.getType(),
                company.getAmountAgents(),
                company.getAddress(),
                company.getAgents_ID(),
                company.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Company company) throws SQLException {
        String sql = String.format(
                "DELETE FROM `Company` WHERE `id`=%d",
                company.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Company> getAll(String where) throws SQLException {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM `Company` " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getInt("amount_agents"),
                        resultSet.getString("address"),
                        resultSet.getInt("Agents_id")
                );
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return companies;
    }
}
