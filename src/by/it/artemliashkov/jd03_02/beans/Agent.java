package by.it.artemliashkov.jd03_02.beans;

public class Agent {
    private long id;
    private String name;
    private String address;
    private int Roles_ID;

    public Agent() {
    }

    public Agent(long id, String name, String address,  int roles_ID) {
        this.id = id;
        this.name = name;
        this.address = address;
        Roles_ID = roles_ID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoles_ID() {
        return Roles_ID;
    }

    public void setRoles_ID(int roles_ID) {
        Roles_ID = roles_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", Roles_ID=" + Roles_ID +
                '}';
    }
}
