package by.it.basumatarau.jd03_03.beans;

import java.sql.Timestamp;

public class Venue {
    private long id;
    private String name;
    private String description;
    private Timestamp openingDeteTime;
    private float fee;
    private long users_Id;
    private long place_Id;

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openingDeteTime=" + openingDeteTime +
                ", fee=" + fee +
                ", users_Id=" + users_Id +
                ", place_Id=" + place_Id +
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

    public Timestamp getOpeningDeteTime() {
        return openingDeteTime;
    }

    public void setOpeningDeteTime(Timestamp openingDeteTime) {
        this.openingDeteTime = openingDeteTime;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public long getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(long users_Id) {
        this.users_Id = users_Id;
    }

    public long getPlace_Id() {
        return place_Id;
    }

    public void setPlace_Id(long place_Id) {
        this.place_Id = place_Id;
    }

    public Venue(long id, String name, String description, Timestamp openingDeteTime, float fee, long users_Id, long place_Id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openingDeteTime = openingDeteTime;
        this.fee = fee;
        this.users_Id = users_Id;
        this.place_Id = place_Id;
    }

    public Venue() {
    }
}
