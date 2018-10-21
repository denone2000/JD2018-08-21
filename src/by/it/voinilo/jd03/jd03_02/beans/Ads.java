package by.it.voinilo.jd03.jd03_02.beans;

public class Ads {
    private long id;
    private String description;
    private String address;
    private String name;
    private String price;
    private String condition;
    private String cellnumber;
    private long roles_id;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    public Ads(long id,
               String description,
               String address,
               String name,
               String price,
               String condition,
               String cellnumber,
               long roles_id) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.name = name;
        this.price = price;
        this.condition = condition;
        this.cellnumber = cellnumber;
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
                ", price='" + price + '\'' +
                ", condition='" + condition + '\'' +
                ", cellnumber='" + cellnumber + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
