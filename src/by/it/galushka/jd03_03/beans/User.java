package by.it.galushka.jd03_03.beans;

public class User {

    private long ID;
    private String Login;
    private String Password;
    private String Email;
    private long roles_Id;

    public User() {
    }

    public User(long ID, String login, String password, String email, long roles_Id) {
        this.ID = ID;
        Login = login;
        Password = password;
        Email = email;
        this.roles_Id = roles_Id;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getRoles_Id() {
        return roles_Id;
    }

    public void setRoles_Id(long roles_Id) {
        this.roles_Id = roles_Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", roles_Id=" + roles_Id +
                "}\n";
    }
}
