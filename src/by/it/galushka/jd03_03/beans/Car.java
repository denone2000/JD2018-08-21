package by.it.galushka.jd03_03.beans;

public class Car {

    private long ID;
    private String Mark;
    private String Model;
    private String Color;
    private double EngineCapacity;
    private String ReleaseDate;
    private long users_ID;

    public Car() {
    }

    public Car(long ID, String mark, String model, String color, double engineCapacity, String releaseDate, long users_ID) {
        this.ID = ID;
        Mark = mark;
        Model = model;
        Color = color;
        EngineCapacity = engineCapacity;
        ReleaseDate = releaseDate;
        this.users_ID = users_ID;
    }

    public long getID() {
        return ID;
    }

    public String getMark() {
        return Mark;
    }

    public String getModel() {
        return Model;
    }

    public String getColor() {
        return Color;
    }

    public double getEngineCapacity() {
        return EngineCapacity;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public long getUsers_ID() {
        return users_ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setEngineCapacity(double engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public void setUsers_ID(long users_ID) {
        this.users_ID = users_ID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", Mark='" + Mark + '\'' +
                ", Model='" + Model + '\'' +
                ", Color='" + Color + '\'' +
                ", EngineCapacity=" + EngineCapacity +
                ", ReleaseDate='" + ReleaseDate + '\'' +
                ", users_ID=" + users_ID +
                '}' + '\n';
    }
}
