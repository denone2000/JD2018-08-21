package by.it.korolchuk.jd03_03;

import by.it.korolchuk.jd03_03.beans.Ad;
import by.it.korolchuk.jd03_03.beans.Role;
import by.it.korolchuk.jd03_03.entityDAO.AdDao;
import by.it.korolchuk.jd03_03.entityDAO.RoleDao;
import by.it.korolchuk.jd03_03.entityDAO.UserDao;

class Dao {

    private static Dao instance;

    UserDao user;
    RoleDao role;
    AdDao ad;


    private Dao() {
    }

    static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {

                if (instance == null) {
                    instance = new Dao();
                    instance.user = new UserDao();
                    instance.role = new RoleDao();
                    instance.ad = new AdDao();
                }
            }
        }
        return instance;
    }
}


