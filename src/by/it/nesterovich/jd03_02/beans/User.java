package by.it.nesterovich.jd03_02.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private String fistName;
    private String lastName;
    private int phoneNumber;
    private long rolesId;

    public User() {
    }

    public User(long id, String login, String password, String email, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rolesId = rolesId;
    }

    public User(long id, String login, String password, String email, String fistName, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fistName = fistName;
        this.rolesId = rolesId;
    }

    public User(long id, String login, String password, String email, String fistName, String lastName, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.rolesId = rolesId;
    }

    public User(long id, String login, String password, String email, String fistName, String lastName, int phoneNumber, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.rolesId = rolesId;
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

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", rolesId=" + rolesId +
                '}';
    }
}
