package by.it.voinilo.jd03.jd03_03;


import by.it.voinilo.jd03.jd03_03.beans.Ads;
import by.it.voinilo.jd03.jd03_03.beans.Role;
import by.it.voinilo.jd03.jd03_03.beans.RoleParam;

class Dao {
    private static Dao instance;

    interfaceDao <Role> role;
    interfaceDao <RoleParam> user;
    interfaceDao <Ads> ad;


    public Dao() {
    }

    static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                if (instance == null)
                    instance = new Dao();
            }
        }

        return instance;

}
}
