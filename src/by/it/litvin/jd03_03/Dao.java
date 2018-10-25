package by.it.litvin.jd03_03;

import by.it.litvin.jd03_03.beansdao.FormDao;
import by.it.litvin.jd03_03.beansdao.Reset;
import by.it.litvin.jd03_03.beansdao.RoleDao;
import by.it.litvin.jd03_03.beansdao.UserDao;

public class Dao {

    private static Dao instance;

    public UserDao user;
    public RoleDao role;
    public FormDao form;

    private Dao(){
    }

    public static Dao getDao(){
        if (instance==null){
            synchronized (Dao.class){
                if (instance==null){
                    instance=new Dao();
                    instance.user=new UserDao();
                    instance.role=new RoleDao();
                    instance.form=new FormDao();
                }
            }
        }
        return instance;
    }
    public void reset(){
        Reset.main(new String[0]);
    }

}
