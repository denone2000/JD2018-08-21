package by.it.basumatarau.jd03_03.customDAO;

import by.it.basumatarau.jd03_03.connection.ConnectionCreator;
import by.it.basumatarau.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO implements InterfaceDAO<Role> {

    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles;
        if((roles=getAll(
                String.format("WHERE `ID`=%d",id)) //"LIMIT 0,1 ;" why limit the query if the id is supposed to be unique?
           ).size()>0){
            return roles.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Role bean) throws SQLException {
        String sqlQuery = String.format("INSERT INTO `Roles`(`Role`) " +
                        "VALUES ('%s')",
                        bean.getRole()
        );
        long id;
        if((id=executeUpdate(sqlQuery))>0){
            bean.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        String sqlQuery = String.format(
                "UPDATE `Roles` SET `Role`='%s' WHERE `ID`=%d",
                bean.getRole(),
                bean.getId());

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        String sqlQuery = String.format("DELETE FROM `Roles` WHERE `ID`=%d",
                bean.getId());

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public List<Role> getAll(String sqlWHERE) throws SQLException {
        List<Role> result = new ArrayList<>();
        String sqlQuery = String.format("SELECT * FROM `Roles` %s ;",
                sqlWHERE
        );

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                result.add(
                        new Role(
                        resultSet.getLong("ID"),
                        resultSet.getString("Role"))
                );
            }
        }
        return result;
    }
}
