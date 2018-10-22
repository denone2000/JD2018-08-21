package by.it.bindyuk.jd03_02;

import java.sql.*;

public class B_ShowUsers {

    public static void main(String[] args){

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            //==========================================================================================================
            //буферные переменные для подсчета пользователей и ролей
            int usersCount = 0;
            int rolesCount = 0;

            //==========================================================================================================
            //inner join на две таблицы со всеми метаданными
            ResultSet resultSet = statement.executeQuery("select * from users INNER JOIN roles ON users.roles_id=roles.id");
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
                usersCount++;
            }
            ResultSet resultSet1 = statement.executeQuery("select * from roles;");
            while (resultSet1.next()){
                rolesCount++;
            }
            System.out.println("Всего пользователей: " + usersCount + "\n" + "Всего ролей: " + rolesCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

