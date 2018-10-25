package by.it.litvin.jd03_02.beans;

public class Form {

    private long id;
    private String name;
    private String surname;
    private String address;
    private String description;
    private int age;
    private String information;
    private String aim;
    private long users_id;

    public Form(){

    }

    public Form(long id, String name, String surname, String address, String description, int age,
                String information, String aim, long users_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.description = description;
        this.age = age;
        this.information = information;
        this.aim = aim;
        this.users_id = users_id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", information='" + information + '\'' +
                ", aim='" + aim + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}

