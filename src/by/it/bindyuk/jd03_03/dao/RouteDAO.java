package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_03.beans.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends AbstractDao implements InterfaceDAO<Route> {

    //==================================================================================================================
    //добавление маршрута в бд
    public boolean create(Route route) throws SQLException {
        String sql = String.format("INSERT INTO `routes`(`city`) VALUES ('%s')",
                route.getCity());
        long id = executeCreate(sql);
        if (id > 0) {
            route.setId(id);
            return true;
        }
        return false;
    }

    //==================================================================================================================
    //прочитать маршрут из бд по id
    public Route read(long id) throws SQLException {
        String where = String.format(" WHERE `id`=%d", id);
        List<Route> listRoutes = getAll(where);
        if (listRoutes.size() == 1) {
            return listRoutes.get(0);
        }
        return null;
    }

    //==================================================================================================================
    //перезеписать маршрут
    public boolean update(Route route) throws SQLException {
        String sql = String.format("UPDATE `routes` SET `city`='%s' WHERE `id`=%d",
                route.getCity(),
                route.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //удалить маршрут
    public boolean delete(Route route) throws SQLException {
        String sql = String.format("DELETE FROM `routes` WHERE `id`=%d",
                route.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //Получаем список всех маршрутов
    @Override
    public List<Route> getAll() throws SQLException {
        List<Route> listRoutes = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `routes`";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Route route = new Route(
                        resultSet.getLong("id"),
                        resultSet.getString("city"));
                listRoutes.add(route);
            }
            return listRoutes;
        }
    }

    //==================================================================================================================
    //Получаем только те маршруты, удовлетворяющие условие(строка where в сигнатуре) для SQL запроса
    @Override
    public List<Route> getAll(String where) throws SQLException {
        List<Route> listRoutes = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `routes` %s;", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Route route = new Route(
                        resultSet.getLong("id"),
                        resultSet.getString("city"));
                listRoutes.add(route);
            }
            return listRoutes;
        }
    }
}
