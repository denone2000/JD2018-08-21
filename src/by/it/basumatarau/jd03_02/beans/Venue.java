package by.it.basumatarau.jd03_02.beans;

import java.sql.Timestamp;

public class Venue {
    private long id;
    private String name;
    private String description;
    private Timestamp openingDateTime;
    private float fee;
    private long users_ID;
    private long place_ID;

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openingDateTime=" + openingDateTime +
                ", fee=" + fee +
                ", users_ID=" + users_ID +
                ", place_ID=" + place_ID +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getOpeningDateTime() {
        return openingDateTime;
    }

    public void setOpeningDateTime(Timestamp openingDateTime) {
        this.openingDateTime = openingDateTime;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public long getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(long users_ID) {
        this.users_ID = users_ID;
    }

    public long getPlace_ID() {
        return place_ID;
    }

    public void setPlace_ID(long place_ID) {
        this.place_ID = place_ID;
    }

    public Venue(long id, String name, String description, Timestamp openingDateTime, float fee, long users_ID, long place_ID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openingDateTime = openingDateTime;
        this.fee = fee;
        this.users_ID = users_ID;
        this.place_ID = place_ID;
    }

    public Venue() {
    }
}
