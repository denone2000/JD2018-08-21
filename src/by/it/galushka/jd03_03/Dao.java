package by.it.galushka.jd03_03;

import by.it.galushka.jd03_03.dao.*;

class Dao {

    private static Dao instance;

    public RoleDao role;
    public UserDao user;
    public CarDao car;
    public OrderDao order;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        car = new CarDao();
        order = new OrderDao();
    }

    static Dao getDao(){
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
