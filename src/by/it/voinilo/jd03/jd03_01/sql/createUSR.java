package by.it.voinilo.jd03.jd03_01.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class createUSR {






    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ) {
            Statement statement =  connection.createStatement();
            statement.executeUpdate("INSERT INTO `roleparam`(`login`, `password`, `email`, `roles_id`)\n" +
                    "VALUES ('user34','useRRRr','US@mail.ru', 1);");
        }
    }
}