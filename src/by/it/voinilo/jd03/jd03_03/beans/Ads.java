package by.it.voinilo.jd03.jd03_03.beans;

import java.util.Objects;

public class Ads {
private  int id;
  private String description;
  private  String address;
  private  String name;
  private int price;
  private  String condition;
  private String number;
  private int roles_id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return id == ads.id &&
                price == ads.price &&
                roles_id == ads.roles_id &&
                Objects.equals(description, ads.description) &&
                Objects.equals(address, ads.address) &&
                Objects.equals(name, ads.name) &&
                Objects.equals(condition, ads.condition) &&
                Objects.equals(number, ads.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, address, name, price, condition, number, roles_id);
    }


    public Ads(int id, String description, String address, String name, int price, String condition, String number, int roles_id) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.name = name;
        this.price = price;
        this.condition = condition;
        this.number = number;
        this.roles_id = roles_id;
    }

    public Ads() {
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", condition='" + condition + '\'' +
                ", number='" + number + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
