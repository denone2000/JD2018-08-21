package by.it.galushka.jd03_03.beans;

public class Order {

    private long ID;
    private String PassportId;
    private String OrderDate;
    private String ReturnDate;
    private String Surname;
    private String Name;
    private String MiddleName;
    private String Address;
    private long users_ID;

    public Order() {
    }

    public Order(long ID, String passportId, String orderDate, String returnDate, String surname, String name, String middleName, String address, long users_ID) {
        this.ID = ID;
        PassportId = passportId;
        OrderDate = orderDate;
        ReturnDate = returnDate;
        Surname = surname;
        Name = name;
        MiddleName = middleName;
        this.Address = address;
        this.users_ID = users_ID;
    }

    public long getID() {
        return ID;
    }

    public String getPassportId() {
        return PassportId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return Name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getAddress() {
        return this.Address;
    }

    public long getUsers_ID() {
        return users_ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setPassportId(String passportId) {
        PassportId = passportId;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setUsers_ID(long users_ID) {
        this.users_ID = users_ID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", PassportId='" + PassportId + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", ReturnDate='" + ReturnDate + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Address='" + Address + '\'' +
                ", users_ID=" + users_ID +
                '}' + '\n';
    }
}
