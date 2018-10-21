package by.it.bindyuk.jd03_03;

import by.it.bindyuk.jd03_03.beans.Role;
import by.it.bindyuk.jd03_03.beans.Route;
import by.it.bindyuk.jd03_03.beans.Ticket;
import by.it.bindyuk.jd03_03.beans.User;

class Dao {

    private static Dao instance;

    InterfaceDAO<User> user;
    InterfaceDAO<Role> role;
    InterfaceDAO<Ticket> ticket;
    InterfaceDAO<Route> route;

    private Dao() {



    }

    static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                if (instance == null) {
                    instance = new Dao();
                }
            }
        }
        return instance;
    }
}
