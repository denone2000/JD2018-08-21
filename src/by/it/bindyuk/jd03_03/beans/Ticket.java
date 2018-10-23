package by.it.bindyuk.jd03_03.beans;

public class Ticket {

    private long id;
    private String transport;
    private long routesIdFrom;
    private long routesIdTo;
    private int data;
    private int month;
    private int year;
    private long usersId;

    public Ticket(long id, String transport, long routesIdFrom, long routesIdTo, int data, int month, int year, long usersId) {
        this.id = id;
        this.transport = transport;
        this.routesIdFrom = routesIdFrom;
        this.routesIdTo = routesIdTo;
        this.data = data;
        this.month = month;
        this.year = year;
        this.usersId = usersId;
    }

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public long getRoutesIdFrom() {
        return routesIdFrom;
    }

    public void setRoutesIdFrom(long routesIdFrom) {
        this.routesIdFrom = routesIdFrom;
    }

    public long getRoutesIdTo() {
        return routesIdTo;
    }

    public void setRoutesIdTo(long routesIdTo) {
        this.routesIdTo = routesIdTo;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", transport='" + transport + '\'' +
                ", routesIdFrom=" + routesIdFrom +
                ", routesIdTo=" + routesIdTo +
                ", data=" + data +
                ", month=" + month +
                ", year=" + year +
                ", usersId=" + usersId +
                '}'+'\n';
    }
}
