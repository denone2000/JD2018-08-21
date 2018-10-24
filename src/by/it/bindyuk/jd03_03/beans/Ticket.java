package by.it.bindyuk.jd03_03.beans;

import java.sql.Timestamp;

public class Ticket {

    private long id;
    private String transport;
    private long routesIdFrom;
    private long routesIdTo;
    private Timestamp data;
    private long usersId;

    public Ticket(long id, String transport, long routesIdFrom, long routesIdTo, Timestamp data, long usersId) {
        this.id = id;
        this.transport = transport;
        this.routesIdFrom = routesIdFrom;
        this.routesIdTo = routesIdTo;
        this.data = data;
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

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
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
                ", usersId=" + usersId +
                '}';
    }
}
