package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_03.beans.Role;
import by.it.bindyuk.jd03_03.beans.User;
import java.sql.*;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Dao dao = Dao.getDao();
        try {
            User user = new User(0, "test",
                    "test", "test", "test",
                    1234, "test", 123, 2);
            dao.user.create(user);
            List<Role> all = dao.role.getAll("WHERE `id`=1");
            System.out.println(all);
            List<Role> all1 = dao.role.getAll();
            System.out.println(all1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
