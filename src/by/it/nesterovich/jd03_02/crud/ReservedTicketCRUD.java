package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.ReservedTicket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservedTicketCRUD {

    public static boolean create(ReservedTicket ReservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    //INSERT INTO `reserved_tickets`(`id`, `code`, `cost`, `users_id`, `films_id`, `cinemas_id`)
                    // VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
                    "INSERT INTO `reserved_tickets`(`code`, `cost`, `users_id`, `films_id`, `cinemas_id`)" +
                            " VALUES (%d,%f,%d,%d,%d);",
                    ReservedTicket.getCode(),
                    ReservedTicket.getCost(),
                    ReservedTicket.getUsersId(),
                    ReservedTicket.getFilmsId(),
                    ReservedTicket.getCinemasId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ReservedTicket.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static ReservedTicket read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `reserved_tickets` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new ReservedTicket(
                        resultSet.getLong("id"),
                        resultSet.getInt("code"),
                        resultSet.getDouble("cost"),
                        resultSet.getLong("users_id"),
                        resultSet.getLong("films_id"),
                        resultSet.getLong("cinemas_id")
                );
            }
            return null;
        }
    }

    public static boolean update(ReservedTicket ReservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `reserved_tickets` SET " +
                            "`code`=%d," +
                            "`cost`=%f," +
                            "`users_id`=%d," +
                            "`films_id`=%d," +
                            "`cinemas_id`=%d" +
                            " WHERE `id`=%d",
                    ReservedTicket.getCode(),
                    ReservedTicket.getCost(),
                    ReservedTicket.getUsersId(),
                    ReservedTicket.getFilmsId(),
                    ReservedTicket.getCinemasId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(ReservedTicket ReservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `reserved_tickets` WHERE `id`=%d",
                    ReservedTicket.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        ReservedTicket ReservedTicket = new ReservedTicket(0, 126413, 2.5, 3, 2, 2);
        if (create(ReservedTicket)) {
            System.out.println("Create OK: " + ReservedTicket);
        }
        long id = ReservedTicket.getId();
        ReservedTicket = read(id);
        if (ReservedTicket != null) {
            System.out.println("Read OK: " + ReservedTicket);
        }
        ReservedTicket.setCinemasId(2);
        if (update(ReservedTicket)) {
            System.out.println("Update OK: " + ReservedTicket);
        }
        if (delete(ReservedTicket)) {
            System.out.println("Delete OK: " + ReservedTicket);
        }
    }
}
