package by.it.bindyuk.jd03_03.dao;

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

    public void reset() {
        Reset.main(new String[0]);
    }

    //==================================================================================================================
    //Singleton, внутри инициализируются все поля DAO
    public static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                if (instance == null) {
                    instance = new Dao();
                    instance.user = new UserDAO();
                    instance.role = new RoleDAO();
                    instance.route = new RouteDAO();
                    instance.ticket = new TicketDAO();
                }
            }
        }
        return instance;
    }
}
