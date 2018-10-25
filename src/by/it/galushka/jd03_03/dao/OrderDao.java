package by.it.galushka.jd03_03.dao;

import by.it.galushka.jd03_03.ConnectionCreator;
import by.it.galushka.jd03_03.InterfaceDao;
import by.it.galushka.jd03_03.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDao implements InterfaceDao<Order> {

    @Override
    public boolean create(Order order) throws SQLException {
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
        long id = executeUpdate(sql);
        if (id > 0) {
            order.setID(id);
        }
        return (id > 0);
    }

    @Override
    public Order read(long id) throws SQLException {
        List<Order> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        }
        return null;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `orders` SET `Passport id`='%s'," +
                        "`Order date`='%s',`Return date`='%s'," +
                        "`Surname`='%s',`Name`='%s',`Middle name`='%s'," +
                        "`Address`='%s',`users_ID`=%d" +
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
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Order order) throws SQLException {
        String sql = String.format("DELETE FROM `orders` WHERE `ID`=%d",
                order.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Order> getAll(String WhereAndOrder) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSetOrders = statement.executeQuery(sql);
            while (resultSetOrders.next()) {
                Order order = new Order();
                order.setID(resultSetOrders.getLong("ID"));
                order.setPassportId(resultSetOrders.getString("Passport id"));
                order.setOrderDate(resultSetOrders.getString("Order date"));
                order.setReturnDate(resultSetOrders.getString("Return date"));
                order.setSurname(resultSetOrders.getString("Surname"));
                order.setName(resultSetOrders.getString("Name"));
                order.setMiddleName(resultSetOrders.getString("Middle name"));
                order.setAddress(resultSetOrders.getString("Address"));
                order.setUsers_ID(resultSetOrders.getLong("users_ID"));
                orders.add(order);
            }
            return orders;
        }
    }
}
