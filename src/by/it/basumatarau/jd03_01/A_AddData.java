package by.it.basumatarau.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {

    static void addData(String name, String description, String place, String openintTime, float fee, int uers_ID){
        String URL_DB = "jdbc:mysql://127.0.0.1:2016"+
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("DB driver loading error: "+ e);
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    String.format(
                            "INSERT INTO `basumatarau`.`Venues` (`ID`, `Name`, `Description`, `Place`, `OpeningDeteTime`, `Fee`, `Users_ID`) VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', '%s');\n",
                            name, description, place, openintTime, fee, uers_ID)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
