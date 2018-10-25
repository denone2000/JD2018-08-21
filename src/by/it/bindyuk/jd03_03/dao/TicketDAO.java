package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_03.beans.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends AbstractDao implements InterfaceDAO<Ticket> {

    //==================================================================================================================
    //запись нового билета в бд
    public boolean create(Ticket ticket) throws SQLException {
        String sql = String.format("INSERT INTO `tickets`(`transport`, " +
                        "`routes_id from`, `routes_id to`, `data`, " +
                        "`users_id`) " +
                        "VALUES ('%s','%d','%d'," +
                        "'%s','%d')",
                ticket.getTransport(),
                ticket.getRoutesIdFrom(),
                ticket.getRoutesIdTo(),
                ticket.getData(),
                ticket.getUsersId());
        long id = executeCreate(sql);
        if (id > 0) {
            ticket.setId(id);
            return true;
        }
        return false;
    }

    //==================================================================================================================
    //прочитать билет из бд по id
    public Ticket read(long id) throws SQLException {
        String where = String.format(" WHERE `id`=%d", id);
        List<Ticket> ticketList = getAll(where);
        if (ticketList.size() == 1) {
            return ticketList.get(0);
        }
        return null;
    }

    //==================================================================================================================
    //перезаписать билет
    public boolean update(Ticket ticket) throws SQLException {
        String sql = String.format("UPDATE `tickets` SET " +
                        "`transport`='%s'," +
                        "`routes_id from`='%d'," +
                        "`routes_id to`='%d'," +
                        "`data`='%s'," +
                        "`users_id`='%d'" +
                        "WHERE `id`=%d",
                ticket.getTransport(),
                ticket.getRoutesIdFrom(),
                ticket.getRoutesIdTo(),
                ticket.getData(),
                ticket.getUsersId(),
                ticket.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //удалить билет
    public boolean delete(Ticket ticket) throws SQLException {
        String sql = String.format("DELETE FROM `tickets` WHERE `id`=%d",
                ticket.getId());
        return (executeUpdate(sql));
    }

    //==================================================================================================================
    //Получаем список всех билетов
    @Override
    public List<Ticket> getAll() throws SQLException {
        List<Ticket> listTickets = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `tickets`";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getLong("id"),
                        resultSet.getString("transport"),
                        resultSet.getLong("routes_id from"),
                        resultSet.getLong("routes_id to"),
                        resultSet.getTimestamp("data"),
                        resultSet.getLong("users_id"));
                listTickets.add(ticket);
            }
            return listTickets;
        }
    }

    //==================================================================================================================
    //Получаем только те билеты, удовлетворяющие условие(строка where в сигнатуре) для SQL запроса
    @Override
    public List<Ticket> getAll(String where) throws SQLException {
        List<Ticket> listTickets = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `tickets` %s;", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getLong("id"),
                        resultSet.getString("transport"),
                        resultSet.getLong("routes_id from"),
                        resultSet.getLong("routes_id to"),
                        resultSet.getTimestamp("data"),
                        resultSet.getLong("users_id"));
                listTickets.add(ticket);
            }
            return listTickets;
        }
    }
}
