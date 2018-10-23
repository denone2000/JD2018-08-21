package by.it.galushka.jd03_02;

import by.it.galushka.jd03_02.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarCRUD {

    static boolean create(Car car) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `cars`(`Mark`, `Model`, `Color`, `Engine capacity`, " +
                            "`Release date`, `users_ID`) VALUES (" +
                            "'%s','%s','%s','%f','%s','%d')",
                    car.getMark(),
                    car.getModel(),
                    car.getColor(),
                    car.getEngineCapacity(),
                    car.getReleaseDate(),
                    car.getUsers_ID());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    car.setID(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Car read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `cars` WHERE `ID`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Car (
                        resultSet.getLong("ID"),
                        resultSet.getString("Mark"),
                        resultSet.getString("Model"),
                        resultSet.getString("Color"),
                        resultSet.getDouble("Engine capacity"),
                        resultSet.getString("Release date"),
                        resultSet.getLong("users_ID")
                );
            }
            return null;
        }
    }

    static boolean update(Car car) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `cars` SET `Mark`='%s',`Model`='%s',`Color`='%s'," +
                            "`Engine capacity`=%f,`Release date`='%s',`users_ID`=%d WHERE `ID`=%d",
                    car.getMark(),
                    car.getModel(),
                    car.getColor(),
                    car.getEngineCapacity(),
                    car.getReleaseDate(),
                    car.getUsers_ID(),
                    car.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    static boolean delete(Car car) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `cars` WHERE `ID`=%d",
                    car.getID());
            return (statement.executeUpdate(sql) == 1);
        }
    }
}