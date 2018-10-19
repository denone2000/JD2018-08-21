package by.it.basumatarau.jd03_02.crud;

import by.it.basumatarau.jd03_02.ConnectionCreator;
import by.it.basumatarau.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public static boolean create(User usr) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("INSERT INTO `Users`(`Login`, `Password`, `Email`, `Roles_ID`) " +
                    "VALUES ('%s','%s','%s','%d')",
                    usr.getLogin(),
                    usr.getPassword(),
                    usr.getEmail(),
                    usr.getRoles_ID()
            );
            if(statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    usr.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }
    static User read(Long usrID) throws SQLException{
        User usr = null;
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("SELECT * FROM `Users` WHERE `ID`=%d",
                    usrID
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                usr = new User(resultSet.getLong("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getInt("Roles_ID"));
            }
        }
        return usr;
    }

    static boolean update(User usr) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sqlQuery = String.format(
                    "UPDATE `Users` SET `Login`='%s'," +
                    "`Password`='%s'," +
                    "`Email`='%s'," +
                    "`Roles_ID`='%s' " +
                            "WHERE `ID`=%d",
                    usr.getLogin(),
                    usr.getPassword(),
                    usr.getEmail(),
                    usr.getRoles_ID(),
                    usr.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    static boolean delete(User usr) throws SQLException{

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("DELETE FROM `Users` WHERE `ID`=%d",
                    usr.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    public static void main(String[] args) throws SQLException{

        User u = new User(0, "blablauser", "verystrong", "blablauser@mail.com", 1);
        create(u);
        System.out.println(read(u.getId()));
        u.setLogin("qwerty");
        update(u);
        System.out.println(read(u.getId()));
        delete(u);

    }
}
