package by.it.nesterovich.jd03_03;

import by.it.nesterovich.jd03_03.beans.*;
import by.it.nesterovich.jd03_03.dao.*;
import by.it.nesterovich.jd03_03.ulils.DataBase;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DataBase.resetAndCreateDBWithTables();
        DataBase.InitTables();

        Dao dao = Dao.getDAO();

        System.out.println("Роли пользователей");
        for (Role role : dao.role.getAll("")) {
            System.out.println(role);
        }

        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>  проверка user  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        showUsers();
        User user = new User(0, "Сергей Иванович", "siivanov", "siivanov@mail.ru", 2);
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();

        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>  проверка film  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        showFilms();
        Film film = new Film(0, "newFilm", "country123", "genre123", 2000, 111);
        if (dao.film.create(film)) System.out.println("\nДобавлен:" + film);
        showFilms();
        film = dao.film.getAll("WHERE ID>3").get(0);
        film.setGenre("new genre");
        if (dao.film.update(film)) System.out.println("\nИзменен:" + film);
        showFilms();
        if (dao.film.delete(film)) System.out.println("\nУдален:" + film);
        showFilms();

        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>  проверка cinema  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        showCinemas();
        Cinema cinema = new Cinema(0, "name1", "address1");
        if (dao.cinema.create(cinema)) System.out.println("\nДобавлен:" + cinema);
        showCinemas();
        cinema = dao.cinema.getAll("WHERE ID>3").get(0);
        cinema.setAddress("new address");
        if (dao.cinema.update(cinema)) System.out.println("\nИзменен:" + cinema);
        showCinemas();
        if (dao.cinema.delete(cinema)) System.out.println("\nУдален:" + cinema);
        showCinemas();

        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>  проверка reservedTicket  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        showReservedTickets();
        ReservedTicket reservedTicket = new ReservedTicket(0, 126413, 2.5, 2, 2, 3);
        if (dao.reservedTicket.create(reservedTicket)) System.out.println("\nДобавлен:" + reservedTicket);
        showReservedTickets();
        reservedTicket = dao.reservedTicket.getAll("WHERE ID>3").get(0);
        reservedTicket.setCost(6.4);
        if (dao.reservedTicket.update(reservedTicket)) System.out.println("\nИзменен:" + reservedTicket);
        showReservedTickets();
        if (dao.reservedTicket.delete(reservedTicket)) System.out.println("\nУдален:" + reservedTicket);
        showReservedTickets();

        System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>  проверка filmCinema  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        showFilmCinemas();
        FilmCinema filmCinema = new FilmCinema(0, 2, 2);
        if (dao.filmCinema.create(filmCinema)) System.out.println("\nДобавлен:" + filmCinema);
        showFilmCinemas();
        filmCinema = dao.filmCinema.getAll("WHERE ID>5").get(0);
        filmCinema.setCinemas_id(3);
        if (dao.filmCinema.update(filmCinema)) System.out.println("\nИзменен:" + filmCinema);
        showFilmCinemas();
        if (dao.filmCinema.delete(filmCinema)) System.out.println("\nУдален:" + filmCinema);
        showFilmCinemas();

    }

    private static void showFilmCinemas() throws SQLException {
        System.out.println("\nТаблица filmCinemas:");
        List<FilmCinema> filmCinemas = new FilmCinemaDao().getAll("");
        for (FilmCinema each : filmCinemas) System.out.println(each);
    }

    private static void showReservedTickets() throws SQLException {
        System.out.println("\nТаблица reservedTickets:");
        List<ReservedTicket> reservedTickets = new ReservedTicketDao().getAll("");
        for (ReservedTicket each : reservedTickets) System.out.println(each);
    }

    private static void showCinemas() throws SQLException {
        System.out.println("\nТаблица cinemas:");
        List<Cinema> cinemas = new CinemaDao().getAll("");
        for (Cinema each : cinemas) System.out.println(each);
    }

    private static void showFilms() throws SQLException {
        System.out.println("\nТаблица films:");
        List<Film> films = new FilmDao().getAll("");
        for (Film each : films) System.out.println(each);
    }

    private static void showUsers() throws SQLException {
        System.out.println("\nТаблица пользователей:");
        List<User> users = new UserDao().getAll("");
        for (User each : users) System.out.println(each);
    }
}
