package by.it.artemliashkov.jd03_02;
import by.it.artemliashkov.jd03_02.beans.Agent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgentCRUD {

    static boolean create(Agent agent) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("INSERT INTO `Agents`(`name`, `address`, `Role_id`) " +
                            "VALUES ('%s','%s','%d')",
                    agent.getName(),
                    agent.getAddress(),
                    agent.getRoles_ID()
            );
            if(statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    agent.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }
    static Agent read(Long AgentID) throws SQLException{
        Agent agent = null;
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("SELECT * FROM `Agents` WHERE `Agents_id`=%d",
                    AgentID
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                agent = new Agent(resultSet.getLong("Agents_id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("Role_id"));
            }
        }
        return agent;
    }

    static boolean update(Agent agent) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sqlQuery = String.format(
                    "UPDATE `Agents` SET `Name`='%s'," +
                            "`Address`='%s'," +
                            "`Role_ID`='%s' " +
                            "WHERE `Agents_id`=%d",
                    agent.getName(),
                    agent.getAddress(),
                    agent.getRoles_ID(),
                    agent.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    static boolean delete(Agent agent) throws SQLException{

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("DELETE FROM `Agents` WHERE `Agents_id`=%d",
                    agent.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    public static void main(String[] args) throws SQLException{

        Agent u = new Agent(5,"artem","ostroshitstskaia",6);
        create(u);
        System.out.println(read(u.getId()));
        u.setName("qwerty");
        update(u);
        System.out.println(read(u.getId()));
        delete(u);

    }
}