package by.it.akhmelev.jd03_03.beans;

public class Ad {

    private long id;
    private String description;
    private String address;
    private int rooms;
    private int floor;
    private int floors;
    private double price;
    private double area;
    private long users_id;

    public Ad() {
    }

    public Ad(long id, String descriprtion, String address, int rooms, int floor, int floors, double price, double area, long users_id) {
        this.id = id;
        this.description = descriprtion;
        this.address = address;
        this.rooms = rooms;
        this.floor = floor;
        this.floors = floors;
        this.price = price;
        this.area = area;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", floor=" + floor +
                ", floors=" + floors +
                ", price=" + price +
                ", area=" + area +
                ", users_id=" + users_id +
                "}\n";
    }
}
