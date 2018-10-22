package by.it.bindyuk.jd03_03.beans;



public class Role {

    private long id;
    private String role;

    public Role(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}'+'\n';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
