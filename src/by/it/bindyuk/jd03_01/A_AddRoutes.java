package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddRoutes {
    private static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static String USER_DB = "root";
    private static String PASSWORD_DB = "";

    static void addRoutes() {

//        Driver driver = new FabricMySQLDriver();
//        DriverManager.registerDriver(driver);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()
        ) {

            //наполнение городами


            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Minsk');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Grodno');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Brest');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Gomel');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Mogilev');");
            statement.executeUpdate("INSERT INTO `bindyuk`.`routes` (`id`, `city`) VALUES (DEFAULT, 'Vitsiebsk');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
