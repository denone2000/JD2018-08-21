package by.it.artemliashkov.jd03_03.dao;

import by.it.artemliashkov.jd03_03.ConnectionCreator;
import by.it.artemliashkov.jd03_03.beans.Agent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgentDao extends AbstractDao implements InterfaceDao<Agent> {

    @Override
    public boolean create(Agent agent) throws SQLException {
        String sql = String.format("INSERT INTO `Agents`(`name`, `address`, `Role_id`) " +
                        "VALUES ('%s','%s','%d')",
                agent.getName(),
                agent.getAddress(),
                agent.getRoles_ID()
        );
        agent.setId(executeUpdate(sql));
        return (agent.getId() > 0);
    }

    @Override
    public Agent read(int id) throws SQLException {
        List<Agent> agents = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (agents.size() > 0) ? agents.get(0) : null;
    }

    @Override
    public boolean update(Agent agent) throws SQLException {
        String sql = String.format(
                "UPDATE `Agents` SET `Name`='%s'," +
                        "`Address`='%s'," +
                        "`Role_ID`='%s' " +
                        "WHERE `Agents_id`=%d",
                agent.getName(),
                agent.getAddress(),
                agent.getRoles_ID(),
                agent.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Agent agent) throws SQLException {
        String sql = String.format(
                "DELETE FROM `Agents` WHERE `Agents_id`=%d",
                agent.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Agent> getAll(String where) throws SQLException {
        List<Agent> agents = new ArrayList<>();
        String sql = "SELECT * FROM agents " + where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Agent agent = new Agent(
                        resultSet.getLong("Agents_id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("Role_id")
                );
                agents.add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //тут нужно логгирование SQLException(e);
        }
        return agents;
    }
}
