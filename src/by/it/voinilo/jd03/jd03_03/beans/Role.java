package by.it.voinilo.jd03.jd03_03.beans;

import java.util.Objects;

public class Role {
    public int id;
    private String login;
    private String password;
    private String email;
    private int roles_id;

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Role user = (Role) o;
        return id == user.id &&
                roles_id == user.roles_id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, roles_id);
    }




    public Role(int id, String login, String password, String email, int roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;
    }


    public Role() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}