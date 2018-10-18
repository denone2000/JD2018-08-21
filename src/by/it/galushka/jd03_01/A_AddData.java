package by.it.galushka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `galushka`.`orders` (`ID`, `Passport id`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '123456789oiuyt', '2018/05/13', '2018/12/01', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);");
            statement.executeUpdate("INSERT INTO `galushka`.`orders` (`ID`, `Passport id`, `Order date`, `Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) VALUES (DEFAULT, '12356789oiuyt', '2018/09/01', '2018/12/31', 'Ivanov', 'Ivan', 'Ivanovich', 'Lenina, 3', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
