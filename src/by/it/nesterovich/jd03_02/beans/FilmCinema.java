package by.it.nesterovich.jd03_02.beans;

public class FilmCinema {

    private long filmId;
    private long cinemaId;

    public FilmCinema() {
    }

    public FilmCinema(long filmId, long cinemaId) {
        this.filmId = filmId;
        this.cinemaId = cinemaId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public String toString() {
        return "FilmCinema{" +
                "filmId=" + filmId +
                ", cinemaId=" + cinemaId +
                '}';
    }
}
