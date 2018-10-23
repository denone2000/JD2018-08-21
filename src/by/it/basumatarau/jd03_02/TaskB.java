package by.it.basumatarau.jd03_02;

import java.sql.*;

public class TaskB {

    private static void showAllUsers() throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = "SELECT Users.ID, Roles.Role, Users.Login " +
                    "FROM `Users` " +
                    "LEFT JOIN Roles " +
                    "ON Users.Roles_ID=Roles.ID";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.printf(
                            "%s = %s\t",
                            metaData.getColumnLabel(i),
                            resultSet.getString(i));
                }
                System.out.print("\n");
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM `Users` ;");
            if(resultSet.next()){
                System.out.printf("total amount of users: %d\n", resultSet.getLong(1));
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM `Roles` ;");
            if(resultSet.next()){
                System.out.printf("total amount of roles: %d\n", resultSet.getLong(1));
            }
        }
    }

    public static void main(String[] args) throws SQLException{
        showAllUsers();
    }
}
