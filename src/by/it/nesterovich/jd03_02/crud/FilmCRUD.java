package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilmCRUD {

    public static boolean create(Film film) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `films`(`name`, `country`, `genre`, `yearOfIssue`, `duration`)" +
                            " VALUES ('%s','%s','%s',%d,%d);",
                    film.getName(),
                    film.getCountry(),
                    film.getGenre(),
                    film.getYearOfIssue(),
                    film.getDuration());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    film.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static Film read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `films` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Film(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getString("genre"),
                        resultSet.getInt("yearOfIssue"),
                        resultSet.getInt("duration")
                );
            }
            return null;
        }
    }

    public static boolean update(Film film) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `films` SET " +
                            "`name`='%s'," +
                            "`country`='%s'," +
                            "`genre`='%s'," +
                            "`yearOfIssue`=%d," +
                            "`duration`=%d" +
                            " WHERE `id`=%d",
                    film.getName(),
                    film.getCountry(),
                    film.getGenre(),
                    film.getYearOfIssue(),
                    film.getDuration(),
                    film.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public  static boolean delete(Film film) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `films` WHERE `id`=%d",
                    film.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Film film = new Film(0, "name", "country", "genre",2000,123);
        if (create(film)) {
            System.out.println("Create OK: " + film);
        }
        long id = film.getId();
        film = read(id);
        if (film != null) {
            System.out.println("Read OK: " + film);
        }
        film.setGenre("Bosh");
        if (update(film)) {
            System.out.println("Update OK: " + film);
        }
        if (delete(film)) {
            System.out.println("Delete OK: " + film);
        }
    }
}
