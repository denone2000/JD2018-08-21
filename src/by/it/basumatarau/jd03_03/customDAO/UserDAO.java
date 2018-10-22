package by.it.basumatarau.jd03_03.customDAO;

import by.it.basumatarau.jd03_03.connection.ConnectionCreator;
import by.it.basumatarau.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO implements InterfaceDAO<User>{

    @Override
    public User read(long id) throws SQLException {
        List<User> users;
        if((users=getAll(String.format("WHERE `ID`=%d ;", id))).size()>0){ //"LIMIT 0,1 ;" why limit the query if the id is supposed to be unique?
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public boolean create(User bean) throws SQLException {
        String sqlQuery = String.format("INSERT INTO `Users`(`Login`, `Password`, `Email`, `Roles_ID`) " +
                        "VALUES ('%s','%s','%s','%d')",
                bean.getLogin(),
                bean.getPassword(),
                bean.getEmail(),
                bean.getRoles_Id()
        );
        long id;
        if((id=executeUpdate(sqlQuery))>0){
            bean.setId(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(User bean) throws SQLException {
        String sqlQuery = String.format(
                "UPDATE `Users` SET `Login`='%s'," +
                        "`Password`='%s'," +
                        "`Email`='%s'," +
                        "`Roles_ID`='%s' " +
                        "WHERE `ID`=%d",
                bean.getLogin(),
                bean.getPassword(),
                bean.getEmail(),
                bean.getRoles_Id(),
                bean.getId());

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(User bean) throws SQLException {
        String sqlQuery = String.format("DELETE FROM `Users` WHERE `ID`=%d",
                bean.getId());

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public List<User> getAll(String sqlWHERE) throws SQLException {
        List<User> result = new ArrayList<>();

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ) {
            String sqlQuery = String.format("SELECT * FROM `Users` %s ;",
                    sqlWHERE
            );

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                result.add(
                        new User(
                                resultSet.getLong("ID"),
                                resultSet.getString("Login"),
                                resultSet.getString("Password"),
                                resultSet.getString("Email"),
                                resultSet.getInt("Roles_ID")
                        )
                );
            }
        }
        return result;
    }
}
