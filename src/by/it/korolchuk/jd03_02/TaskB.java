package by.it.korolchuk.jd03_02;


import java.sql.*;

public class TaskB {
    public static void main(String[] args) throws SQLException {


        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int userCounter = 0;
            int roleCounter = 0;

            ResultSet resultSet = statement.executeQuery(
                    "select * from users INNER JOIN roles ON users.roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(
                            metaData.getColumnLabel(i) + " = " +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
                userCounter++;
            }
            ResultSet resultSet1 = statement.executeQuery("select * from roles;");
            while (resultSet1.next()) {
                roleCounter++;
            }
            System.out.println("Number of users " + userCounter + "\n" + "Number of roles" + roleCounter);
        }
    }
}