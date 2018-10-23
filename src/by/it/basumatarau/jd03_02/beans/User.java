package by.it.basumatarau.jd03_02.beans;

public class User {
    private long id;
    private String login;
    private String password;
    private String email;
    private int Roles_ID;

    public User() {
    }

    public User(long id, String login, String password, String email, int roles_ID) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        Roles_ID = roles_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Roles_ID=" + Roles_ID +
                '}';
    }
}
