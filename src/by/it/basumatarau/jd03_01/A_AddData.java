package by.it.basumatarau.jd03_01;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

class A_AddData {

    static void addData(String name, String description, Long openintTime, float fee, int uers_ID,
                        String placeName, String placeAddress){
        String URL_DB = "jdbc:mysql://127.0.0.1:2016"+
                "?useUnicode=true&characterEncoding=UTF-8";
        String USER_DB = "root";
        String PASSWORD_DB = "";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("DB driver loading error: "+ e);
        }

        long newPlaceID=0L;
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    String.format(
                            "INSERT INTO `basumatarau`.`Places` (`ID`, `Name`, `Address`) " +
                                    "VALUES (DEFAULT, '%s', '%s');",
                            placeName, placeAddress),
                    Statement.RETURN_GENERATED_KEYS
            );
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
               newPlaceID=generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB)){
            Statement statement = connection.createStatement();

            NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
            statement.executeUpdate(

                    String.format("INSERT INTO `basumatarau`.`Venues` " +
                                    "(`ID`, `Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) " +
                                    "VALUES (DEFAULT, '%s', '%s', %3d, %s, %3d, %3d);",
                            name, description, openintTime, nf.format(fee), 3L, 1L)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
