package by.it.voinilo.jd03.jd03_03.beans;

import java.util.Objects;

public class RoleParam {

    static private int id;
    static private String role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    static public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleParam role1 = (RoleParam) o;
        return id == role1.id &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    public RoleParam(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleParam() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

}
