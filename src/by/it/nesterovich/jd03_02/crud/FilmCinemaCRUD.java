package by.it.nesterovich.jd03_02.crud;

import by.it.nesterovich.jd03_02.ConnectionCreator;
import by.it.nesterovich.jd03_02.beans.FilmCinema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilmCinemaCRUD {

    public static boolean create(FilmCinema filmCinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `films_cinemas`(`films_id`, `cinemas_id`)" +
                            " VALUES (%d,%d);",
                    filmCinema.getFilmId(),
                    filmCinema.getCinemaId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    filmCinema.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public static FilmCinema read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `films_cinemas` WHERE `id`=%d ", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new FilmCinema(
                        resultSet.getLong("id"),
                        resultSet.getLong("films_id"),
                        resultSet.getLong("cinemas_id")
                );
            }
            return null;
        }
    }

    public static boolean update(FilmCinema filmCinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `films_cinemas` SET " +
                            "`films_id`=%d," +
                            "`cinemas_id`=%d " +
                            "WHERE `id`=%d",
                    filmCinema.getFilmId(),
                    filmCinema.getCinemaId(),
                    filmCinema.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static boolean delete(FilmCinema filmCinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `films_cinemas` WHERE `id`=%d",
                    filmCinema.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        FilmCinema filmCinema = new FilmCinema(0, 2, 1);
        if (create(filmCinema)) {
            System.out.println("Create OK: " + filmCinema);
        }
        long id = filmCinema.getId();
        filmCinema = read(id);
        if (filmCinema != null) {
            System.out.println("Read OK: " + filmCinema);
        }
        filmCinema.setCinemaId(4);
        filmCinema.setFilmId(4);
        if (update(filmCinema)) {
            System.out.println("Update OK: " + filmCinema);
        }
        if (delete(filmCinema)) {
            System.out.println("Delete OK: " + filmCinema);
        }
    }
}
