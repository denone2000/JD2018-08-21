package by.it.nesterovich.jd03_03;

import by.it.nesterovich.jd03_03.beans.*;
import by.it.nesterovich.jd03_03.daouniversal.UniversalDao;
import by.it.nesterovich.jd03_03.ulils.DataBase;

import java.sql.SQLException;

public class RunnerUniversalDao {

    public static void main(String[] args) throws SQLException {
        DataBase.resetAndCreateDBWithTables();
        DataBase.InitTables();

        System.out.println("\n========================= >>>>> проверка User <<<<< =========================\n");
        UniversalDao<User> daoUser = new UniversalDao<>(new User(), "users");
        User user = new User(0, "ТестовыйЛогин", "ТестовыйПароль", "Тестовый Email", 2);
        daoUser.create(user);
        System.out.println("Создан: " + user);
        daoUser.update(user);
        user.setEmail("Новый Email");
        System.out.println("Обновлен: " + user);
        if (daoUser.delete(user)) {
            System.out.println("Удален: " + user);
        }
        System.out.println("\nСписок всех записей:");
        for (User current : daoUser.getAll("")) {
            System.out.println(current);
        }

        System.out.println("\n========================= >>>>> проверка Film <<<<< =========================\n");
        UniversalDao<Film> daoFilm = new UniversalDao<>(new Film(), "films");
        Film film = new Film(0, "newFilm", "country12", "genre12", 2000, 111);
        daoFilm.create(film);
        System.out.println("Создан: " + film);
        daoFilm.update(film);
        film.setCountry("Новый Country");
        System.out.println("Обновлен: " + film);
        if (daoFilm.delete(film)) {
            System.out.println("Удален: " + film);
        }
        System.out.println("\nСписок всех записей:");
        for (Film current : daoFilm.getAll("")) {
            System.out.println(current);
        }

        System.out.println("\n========================= >>>>> проверка Cinema <<<<< =========================\n");
        UniversalDao<Cinema> daoCinema = new UniversalDao<>(new Cinema(), "cinemas");
        Cinema cinema = new Cinema(0, "test name", " test address");
        daoCinema.create(cinema);
        System.out.println("Создан: " + cinema);
        daoCinema.update(cinema);
        cinema.setAddress("Новый address");
        System.out.println("Обновлен: " + cinema);
        if (daoCinema.delete(cinema)) {
            System.out.println("Удален: " + cinema);
        }
        System.out.println("\nСписок всех записей:");
        for (Cinema current : daoCinema.getAll("")) {
            System.out.println(current);
        }

        System.out.println("\n========================= >>>>> проверка ReservedTicket <<<<< =========================\n");
        UniversalDao<ReservedTicket> daoReservedTicket = new UniversalDao<>(new ReservedTicket(), "reserved_tickets");
        ReservedTicket reservedTicket = new ReservedTicket(0, 126413, 2.5, 2, 2, 3);
        daoReservedTicket.create(reservedTicket);
        System.out.println("Создан: " + reservedTicket);
        daoReservedTicket.update(reservedTicket);
        reservedTicket.setCost(7.4);
        System.out.println("Обновлен: " + reservedTicket);
        if (daoReservedTicket.delete(reservedTicket)) {
            System.out.println("Удален: " + reservedTicket);
        }
        System.out.println("\nСписок всех записей:");
        for (ReservedTicket current : daoReservedTicket.getAll("")) {
            System.out.println(current);
        }

        System.out.println("\n========================= >>>>> проверка FilmCinema <<<<< =========================\n");
        UniversalDao<FilmCinema> daoFilmCinema = new UniversalDao<>(new FilmCinema(), "films_cinemas");
        FilmCinema filmCinema = new FilmCinema(0, 2, 2);
        daoFilmCinema.create(filmCinema);
        System.out.println("Создан: " + filmCinema);
        daoFilmCinema.update(filmCinema);
        filmCinema.setCinemas_id(3);
        System.out.println("Обновлен: " + filmCinema);
        if (daoFilmCinema.delete(filmCinema)) {
            System.out.println("Удален: " + filmCinema);
        }
        System.out.println("\nСписок всех записей:");
        for (FilmCinema current : daoFilmCinema.getAll("")) {
            System.out.println(current);
        }
    }
}
