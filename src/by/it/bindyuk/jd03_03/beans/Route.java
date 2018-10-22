package by.it.bindyuk.jd03_03.beans;

public class Route {

    private long id;
    private String city;

    public Route(long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Route() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}'+'\n';
    }
}
