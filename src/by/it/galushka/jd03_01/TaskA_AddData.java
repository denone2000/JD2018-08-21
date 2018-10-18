package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class TaskA_AddData {

    static void addData() {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `galushka`.`orders` (`ID`, `Passport id`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '123456789oiuyt', '2018/05/13', '2018/12/01', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);");
            statement.executeUpdate("INSERT INTO `galushka`.`orders` (`ID`, `Passport id`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '12356789oiuyt', '2018/09/01', '2018/12/31', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);");
            statement.executeUpdate("INSERT INTO `galushka`.`cars` (`ID`, `Mark`, `Model`, `Color`, `Engine capacity`, `Release date`, `users_ID`) VALUES (DEFAULT, 'Audi', 'A6', 'Black', 2.5, '2018/03/01', 4);");
            System.out.println("--->Data added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
