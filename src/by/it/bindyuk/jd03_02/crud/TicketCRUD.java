package by.it.bindyuk.jd03_02.crud;

import by.it.bindyuk.jd03_02.ConnectionCreator;
import by.it.bindyuk.jd03_02.beans.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketCRUD {

    //==================================================================================================================
    //запись нового билета в бд
    public static boolean create(Ticket ticket) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `tickets`(`transport`," +
                            " `routes_id from`, `routes_id to`, `data`, `month`," +
                            " `year`, `users_id`) " +
                            "VALUES ('%s','%d','%d'," +
                            "'%d','%d','%d','%d')",
                    ticket.getTransport(),
                    ticket.getRoutesIdFrom(),
                    ticket.getRoutesIdTo(),
                    ticket.getData(),
                    ticket.getMonth(),
                    ticket.getYear(),
                    ticket.getUsersId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ticket.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    //==================================================================================================================
    //прочитать билет из бд по id
    public static Ticket read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `tickets` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Ticket(
                        resultSet.getLong("id"),
                        resultSet.getString("transport"),
                        resultSet.getLong("routes_id from"),
                        resultSet.getLong("routes_id to"),
                        resultSet.getInt("data"),
                        resultSet.getInt("month"),
                        resultSet.getInt("year"),
                        resultSet.getLong("users_id"));
            }
            return null;
        }
    }

    //==================================================================================================================
    //перезаписать билет
    public static boolean update(Ticket ticket) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `tickets` SET " +
                            "`transport`='%s'," +
                            "`routes_id from`='%d'," +
                            "`routes_id to`='%d'," +
                            "`data`='%d'," +
                            "`month`='%d'," +
                            "`year`='%d'," +
                            "`users_id`='%d'" +
                            "WHERE `id`=%d",
                    ticket.getTransport(),
                    ticket.getRoutesIdFrom(),
                    ticket.getRoutesIdTo(),
                    ticket.getData(),
                    ticket.getMonth(),
                    ticket.getYear(),
                    ticket.getUsersId(),
                    ticket.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    //==================================================================================================================
    //удалить билет
    public static boolean delete(Ticket ticket) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `tickets` WHERE `id`=%d",
                    ticket.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws SQLException {
        Ticket ticket = new Ticket(0,"train",2,3,21,10,2019,2);

        if (create(ticket)) {
            System.out.println("ALL IS OKEY!" + '\n' + ticket);
        }
        long id = ticket.getId();
        ticket = read(id);
        if (ticket != null) {
            System.out.println("READING IS OKEY" + '\n' + ticket);
        }
        ticket.setRoutesIdFrom(4);
        if (update(ticket)) {
            System.out.println("UPDATING IS OK" + '\n' + ticket);
        }
        if (delete(ticket)) {
            System.out.println("DELETE" + '\n' + ticket);
        }
    }

}
