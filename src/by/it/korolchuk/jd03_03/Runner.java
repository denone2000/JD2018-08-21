package by.it.korolchuk.jd03_03;


import by.it.korolchuk.jd03_03.beans.Ad;
import by.it.korolchuk.jd03_03.beans.Role;
import by.it.korolchuk.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {


    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        //dao.reset();

        User user = new User(0, "UserDao", "UserDao", "UserDao@user.ru", 2);
        if (dao.user.create(user))
            System.out.println("CREATE:\n" + dao.user.getAll());
        user = dao.user.read(user.getId());
        user.setLogin("uuuuuu");
        if (dao.user.update(user))
            System.out.println("UPDATE:\n" + dao.user.getAll());
        if (dao.user.delete(user))
            System.out.println("DELETE:\n" + dao.user.getAll());

        Role role = new Role(0, "RoleDao");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getAll());
        role = dao.role.read(role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getAll());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getAll());

        Ad ad = new Ad(0, "description", "animal", "greed", "sex", 12, 35, "quality", 2);
        if (dao.ad.create(ad))
            System.out.println("CREATE:\n" + dao.ad.getAll());
        ad = dao.ad.read(ad.getId());
        ad.setDescription("ddddddd");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:\n" + dao.ad.getAll());
        if (dao.ad.delete(ad))
            System.out.println("DELETE:" + dao.ad.getAll());
    }
}
