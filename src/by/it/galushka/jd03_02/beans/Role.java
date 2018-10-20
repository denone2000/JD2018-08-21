package by.it.galushka.jd03_02.beans;

public class Role {

    private long ID;
    private String Role;

    public Role() {
    }

    public Role(long id, String role) {
        this.ID = id;
        this.Role = role;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }
}
