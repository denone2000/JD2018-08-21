package by.it.nesterovich.jd03_02.beans;

public class FilmCinema {

    private long id;
    private long filmId;
    private long cinemaId;

    public FilmCinema() {
    }

    public FilmCinema(long id, long filmId, long cinemaId) {
        this.id = id;
        this.filmId = filmId;
        this.cinemaId = cinemaId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", filmId=" + filmId +
                ", cinemaId=" + cinemaId +
                '}';
    }
}
