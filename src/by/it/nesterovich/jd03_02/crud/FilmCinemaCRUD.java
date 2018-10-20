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
            return (statement.executeUpdate(sql) != 0);
        }
    }

    public static FilmCinema read(long filmId, long cinemaId) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `films_cinemas` WHERE `films_id`=%d AND `cinemas_id`=%d ", filmId, cinemaId);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new FilmCinema(
                        resultSet.getLong("films_id"),
                        resultSet.getLong("cinemas_id")
                );
            }
            return null;
        }
    }

    public static boolean delete(FilmCinema filmCinema) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `films_cinemas` WHERE `films_id`=%d AND `cinemas_id`=%d",
                    filmCinema.getFilmId(),
                    filmCinema.getCinemaId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        FilmCinema filmCinema = new FilmCinema(3, 1);
        if (create(filmCinema)) {
            System.out.println("Create OK: " + filmCinema);
        }
        filmCinema = read(filmCinema.getFilmId(), filmCinema.getCinemaId());
        if (filmCinema != null) {
            System.out.println("Read OK: " + filmCinema);
        }
        if (delete(filmCinema)) {
            System.out.println("Delete OK: " + filmCinema);
        }
    }
}
