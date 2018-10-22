package by.it.akhmelev.jd03_03;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beansdao.*;

class Dao {

    private static Dao instance;

    public UserDao user;
    public RoleDao role;
    public InterfaceDao<Ad> ad;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        ad = new UniversalDAO<>(new Ad(), "ads");
    }

    public static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                instance = new Dao();
            }
        }
        return instance;
    }

    public void reset() {
        Reset.main(new String[0]);
    }
}
