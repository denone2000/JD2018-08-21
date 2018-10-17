package by.it.bindyuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    static String URL_DB = "jdbc:mysql://127.0.0.1:2016/" +
            "?useUnicode=true&characterEncoding=UTF-8";
    static String USER_DB = "root";
    static String PASSWORD_DB = "";

    public static void addData() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `placefrom`, `placeto`, `date`, `month`, `year`, `passport series`, `passport id`," +
                    " `bancard number`, `cid`, `users_id`) VALUES (DEFAULT, 'train', 'Minsk', 'Grodno', 5, 11, 2018, 'MP', 2445551, '2438200000886500', 189, 3);\n");

            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `placefrom`, `placeto`, `date`, `month`, `year`, `passport series`, `passport id`," +
                    " `bancard number`, `cid`, `users_id`) VALUES (DEFAULT, 'bus', 'Minsk', 'Mogilev', 7, 02, 2019, 'MP', 8734029, '3456789720598300', 965, 3);\n");

            statement.executeUpdate("INSERT INTO `bindyuk`.`tickets` (`id`, `transport`, `placefrom`, `placeto`, `date`, `month`, `year`, `passport series`, `passport id`," +
                    " `bancard number`, `cid`, `users_id`) VALUES (DEFAULT, 'bus', 'Vitsiebsk', 'Mozyr', 1, 01, 2019, 'MP', 2737781, '2668207720882000', 253, 3);\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
