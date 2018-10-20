package by.it.galushka.jd03_02;

import by.it.galushka.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderCRUD {

    static boolean create(Order order) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `orders`(`Passport id`, `Order date`, " +
                            "`Return date`, `Surname`, `Name`, `Middle name`, `Address`, `users_ID`) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s','%s','%d')",
                    order.getPassportId(),
                    order.getOrderDate(),
                    order.getReturnDate(),
                    order.getSurname(),
                    order.getName(),
                    order.getMiddleName(),
                    order.getAddress(),
                    order.getUsers_ID());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setID(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Order read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `orders` WHERE `ID`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Order (
                        resultSet.getLong("ID"),
                        resultSet.getString("Passport id"),
                        resultSet.getString("Order date"),
                        resultSet.getString("Return date"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Name"),
                        resultSet.getString("Middle name"),
                        resultSet.getString("Address"),
                        resultSet.getLong("users_ID")
                );
            }
            return null;
        }
    }

    static boolean update(Order order) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `orders` SET `Passport id`='%s',`Order date`='%s',`Return date`='%s'," +
                            "`Surname`='%s',`Name`='%s',`Middle name`='%s',`Address`='%s',`users_ID`=%d" +
                            " WHERE `ID`=%d",
                    order.getPassportId(),
                    order.getOrderDate(),
                    order.getReturnDate(),
                    order.getSurname(),
                    order.getName(),
                    order.getMiddleName(),
                    order.getAddress(),
                    order.getUsers_ID(),
                    order.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Order order) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `orders` WHERE `ID`=%d",
                    order.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}
