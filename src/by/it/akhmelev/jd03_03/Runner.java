package by.it.akhmelev.jd03_03;


import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beans.Role;
import by.it.akhmelev.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {


    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        //dao.reset();

        User user = new User(0, "UserDao", "UserDao", "UserDao@user.ru", 2);
        if (dao.user.create(user))
            System.out.println("CREATE:" + dao.user.getAll());
        user = dao.user.read(user.getId());
        user.setLogin("uuuuuu");
        if (dao.user.update(user))
            System.out.println("UPDATE:" + dao.user.getAll());
        if (dao.user.delete(user))
            System.out.println("\nDELETE:" + dao.user.getAll());

        Role role = new Role(0, "RoleDao");
        if (dao.role.create(role))
            System.out.println("CREATE:" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:" + dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("\nDELETE:" + dao.role.getAll());

        Ad ad = new Ad();
        ad.setDescription("ad dao test ad dao test ad dao test ");
        ad.setUsers_id(2);
        if (dao.ad.create(ad))
            System.out.println("CREATE:" + dao.ad.getAll());
        ad = dao.ad.read(ad.getId());
        ad.setDescription("ddddddd");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:" + dao.ad.getAll());
        if (dao.ad.delete(ad))
            System.out.println("\nDELETE:" + dao.ad.getAll());
    }
}
