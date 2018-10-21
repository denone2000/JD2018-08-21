package by.it.akhmelev.jd03_03.simpledao;

import by.it.akhmelev.jd03_03.InterfaceDao;
import by.it.akhmelev.jd03_03.UniversalDAO;
import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beans.Role;
import by.it.akhmelev.jd03_03.beans.User;

public enum Dao {

    INSTANCE;

    public InterfaceDao<Role> role = new UniversalDAO<>(new Role(), "roles");
    public InterfaceDao<User> user = new UniversalDAO<>(new User(), "users");
    public InterfaceDao<Ad> ad = new UniversalDAO<>(new Ad(), "ads");
}
