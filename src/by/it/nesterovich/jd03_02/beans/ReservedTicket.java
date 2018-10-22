package by.it.nesterovich.jd03_02.beans;

public class ReservedTicket {

    private long id;
    private int code;
    private double cost;
    private long usersId;
    private long filmsId;
    private long cinemasId;

    public ReservedTicket() {
    }

    public ReservedTicket(long id, int code, double cost, long usersId, long filmsId, long cinemasId) {
        this.id = id;
        this.code = code;
        this.cost = cost;
        this.usersId = usersId;
        this.filmsId = filmsId;
        this.cinemasId = cinemasId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getFilmsId() {
        return filmsId;
    }

    public void setFilmsId(long filmsId) {
        this.filmsId = filmsId;
    }

    public long getCinemasId() {
        return cinemasId;
    }

    public void setCinemasId(long cinemasId) {
        this.cinemasId = cinemasId;
    }

    @Override
    public String toString() {
        return "ReservedTickets{" +
                "id=" + id +
                ", code=" + code +
                ", cost=" + cost +
                ", usersId=" + usersId +
                ", filmsId=" + filmsId +
                ", cinemasId=" + cinemasId +
                '}';
    }
}
