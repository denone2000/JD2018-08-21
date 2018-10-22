package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.Cinema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CinemaCRUD {

    public static boolean create(Cinema cinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    //INSERT INTO `cinemas`(`id`, `name`, `address`) VALUES ([value-1],[value-2],[value-3])
                    "INSERT INTO `cinemas`(`name`, `address`)" +
                            " VALUES ('%s','%s');",
                    cinema.getName(),
                    cinema.getAddress());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cinema.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static Cinema read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `cinemas` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Cinema(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address")
                );
            }
            return null;
        }
    }

    public static boolean update(Cinema cinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {       //UPDATE `cinemas` SET `name`=[value-2],`address`=[value-3] WHERE 1
            String sql = String.format(
                    "UPDATE `cinemas` SET " +
                            "`name`='%s'," +
                            "`address`='%s'" +
                            " WHERE `id`=%d",
                    cinema.getName(),
                    cinema.getAddress(),
                    cinema.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(Cinema cinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `cinemas` WHERE `id`=%d",
                    cinema.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Cinema cinema = new Cinema(0, "name1", "address1");
        if (create(cinema)) {
            System.out.println("Create OK: " + cinema);
        }
        long id = cinema.getId();
        cinema = read(id);
        if (cinema != null) {
            System.out.println("Read OK: " + cinema);
        }
        cinema.setName("updateName");
        if (update(cinema)) {
            System.out.println("Update OK: " + cinema);
        }
        if (delete(cinema)) {
            System.out.println("Delete OK: " + cinema);
        }
    }
}
