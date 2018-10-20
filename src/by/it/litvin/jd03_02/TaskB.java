package by.it.litvin.jd03_02;

import java.sql.*;

public class TaskB {
    private static int usersCount = 0;
    private static int rolesCount = 0;

    public static void main(String[] args) {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON " +
                    "users.roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(metaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");

                }
                System.out.println();
                usersCount++;
            }
            ResultSet resultSet1 = statement.executeQuery("select*from roles;");
            while (resultSet1.next()) {
                rolesCount++;
            }
            System.out.println("All users: " + usersCount + "\n" + "All roles: " + rolesCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
