package by.it.korolchuk.jd03_02;

import by.it.korolchuk.jd03_02.beans.Ad;
import by.it.korolchuk.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) throws SQLException {

        getUsersList();
    }

    static String getUsersList() throws SQLException {
        String login = null;

        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT login FROM `users` ");
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                login = resultSet.getString("login");
                System.out.println(login);
            }
            return login;
        }
    }

}
