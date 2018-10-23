package by.it.galushka.jd03_03;

import by.it.galushka.jd03_02.beans.User;

public class Dao {

    private static Dao instance;

    InterfaceDAO<User> role;
    InterfaceDAO<User> user;
    InterfaceDAO<User> car;
    InterfaceDAO<User> order;

    private Dao() {
    }

    Dao getDao(){
        if(instance == null){
            synchronized (Dao.class){
                if(instance==null){
                    instance = new Dao();
                }
            }
        }
        return instance;
    }
}
