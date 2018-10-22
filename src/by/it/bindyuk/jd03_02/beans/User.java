package by.it.bindyuk.jd03_02.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private String passpostSeries;
    private int passportId;
    private String bancardNumber;
    private int cid;
    private long roles_id;

    public User(long id, String login, String password, String email,
                String passpostSeries, int passportId, String bancardNumber, int cid, long rolesId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.passpostSeries = passpostSeries;
        this.passportId = passportId;
        this.bancardNumber = bancardNumber;
        this.cid = cid;
        this.roles_id = rolesId;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", passpostSeries='" + passpostSeries + '\'' +
                ", passportId=" + passportId +
                ", bancardNumber='" + bancardNumber + '\'' +
                ", cid=" + cid +
                ", roles_id=" + roles_id +
                '}';
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

    public String getPasspostSeries() {
        return passpostSeries;
    }

    public void setPasspostSeries(String passpostSeries) {
        this.passpostSeries = passpostSeries;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getBancardNumber() {
        return bancardNumber;
    }

    public void setBancardNumber(String bancardNumber) {
        this.bancardNumber = bancardNumber;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }
}
