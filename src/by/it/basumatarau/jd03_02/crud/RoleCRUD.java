package by.it.basumatarau.jd03_02.crud;

import by.it.basumatarau.jd03_02.ConnectionCreator;
import by.it.basumatarau.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    public static boolean create(Role role) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("INSERT INTO `Roles`(`Role`) " +
                            "VALUES ('%s')",
                    role.getRole()
            );
            if(statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    role.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    static Role read(Long roleID) throws SQLException{
        Role role = null;
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("SELECT * FROM `Roles` WHERE `ID`=%d",
                    roleID
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                role = new Role(resultSet.getLong("ID"),
                        resultSet.getString("Role"));
            }
        }
        return role;
    }

    static boolean update(Role role) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sqlQuery = String.format(
                    "UPDATE `Roles` SET `Role`='%s' WHERE `ID`=%d",
                    role.getRole(),
                    role.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    static boolean delete(Role role) throws SQLException{

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("DELETE FROM `Roles` WHERE `ID`=%d",
                    role.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    public static void main(String[] args) throws SQLException{

        Role r = new Role(0, "terminator");
        create(r);
        System.out.println(read(r.getId()));
        r.setRole("hellokitty");
        update(r);
        System.out.println(read(r.getId()));
        delete(r);

    }
    
}
