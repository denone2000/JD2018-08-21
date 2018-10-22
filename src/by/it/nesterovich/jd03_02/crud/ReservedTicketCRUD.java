package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.ReservedTicket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ReservedTicketCRUD {

    public static boolean create(ReservedTicket reservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.ENGLISH,
                    "INSERT INTO `reserved_tickets`(`code`, `cost`, `users_id`, `films_id`, `cinemas_id`)" +
                            " VALUES (%d,%f,%d,%d,%d);",
                    reservedTicket.getCode(),
                    reservedTicket.getCost(),
                    reservedTicket.getUsersId(),
                    reservedTicket.getFilmsId(),
                    reservedTicket.getCinemasId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    reservedTicket.setId(generatedKeys.getLong(1));
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

    public static boolean update(ReservedTicket reservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.ENGLISH,
                    "UPDATE `reserved_tickets` SET " +
                            "`code`=%d," +
                            "`cost`=%f," +
                            "`users_id`=%d," +
                            "`films_id`=%d," +
                            "`cinemas_id`=%d" +
                            " WHERE `id`=%d",
                    reservedTicket.getCode(),
                    reservedTicket.getCost(),
                    reservedTicket.getUsersId(),
                    reservedTicket.getFilmsId(),
                    reservedTicket.getCinemasId(),
                    reservedTicket.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(ReservedTicket reservedTicket) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `reserved_tickets` WHERE `id`=%d",
                    reservedTicket.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        ReservedTicket reservedTicket = new ReservedTicket(0, 126413, 2.5, 3, 2, 2);
        if (create(reservedTicket)) {
            System.out.println("Create OK: " + reservedTicket);
        }
        long id = reservedTicket.getId();
        reservedTicket = read(id);
        if (reservedTicket != null) {
            System.out.println("Read OK: " + reservedTicket);
        }
        reservedTicket.setCinemasId(2);
        if (update(reservedTicket)) {
            System.out.println("Update OK: " + reservedTicket);
        }
        if (delete(reservedTicket)) {
            System.out.println("Delete OK: " + reservedTicket);
        }
    }
}
