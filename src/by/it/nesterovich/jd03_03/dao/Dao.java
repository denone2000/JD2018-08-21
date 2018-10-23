package by.it.nesterovich.jd03_03.dao;

public class Dao {

    private static Dao dao;

    public UserDao user;
    public RoleDao role;
    public FilmDao film;
    public CinemaDao cinema;
    public ReservedTicketDao reservedTicket;
    public FilmCinemaDao filmCinema;

    private Dao() {
    }

    public static Dao getDAO() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                    dao.user = new UserDao();
                    dao.role = new RoleDao();
                    dao.film = new FilmDao();
                    dao.cinema = new CinemaDao();
                    dao.reservedTicket = new ReservedTicketDao();
                    dao.filmCinema = new FilmCinemaDao();
                }
            }
        }
        return dao;
    }
}
