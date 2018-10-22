package by.it.korolchuk.jd03_03;

import by.it.korolchuk.jd03_03.beans.Ad;
import by.it.korolchuk.jd03_03.beans.Role;
import by.it.korolchuk.jd03_03.entityDAO.UserDao;

class Dao {

    private static Dao instance;

    UserDao user;
    InterfaceDAO<Role> role;
    InterfaceDAO<Ad> ad;


    private Dao() {
        user = new UserDao();
    }

    static Dao getDao() {
        if (instance == null)
            synchronized (Dao.class) {

                if (instance == null)
                    instance = new Dao();
            }
        return instance;
    }
}


