package by.it.bindyuk.jd03_02.crud;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_02.beans.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RouteCRUD {

    //==================================================================================================================
    //добавление маршрута в бд
    public static boolean create(Route route) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `routes`(`city`) VALUES ('%s')",
                    route.getCity());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    route.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    //==================================================================================================================
    //прочитать маршрут из бд по id
    public static Route read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `routes` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Route(
                        resultSet.getLong("id"),
                        resultSet.getString("city"));
            }
            return null;
        }
    }

    //==================================================================================================================
    //перезеписать маршрут
    public static boolean update(Route route) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `routes` SET `city`='%s' WHERE `id`=%d",
                    route.getCity(),
                    route.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    //==================================================================================================================
    //удалить маршрут
    public static boolean delete(Route route) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = String.format("DELETE FROM `routes` WHERE `id`=%d",
                    route.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws SQLException {
        Route route = new Route(0, "Orhsa");
        if (create(route))
            System.out.println("Create OK: " + route);
        long id = route.getId();
        route = null;
        route = read(id);
        if (route != null)
            System.out.println("Read OK: " + route);
        route.setCity("Osipovichi");
        if (update(route))
            System.out.println("Updating: " + route);
        if (delete(route))
            System.out.println("Deliting: " + route);
    }

}
