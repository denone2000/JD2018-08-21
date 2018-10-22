package by.it.galushka.jd03_03;

import by.it.galushka.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        User user = new User(0, "UserDao", "UserDao", "UserDao@user.ru", 2);
        if (dao.user.create(user))
            System.out.println("CREATE:\n" + dao.user.getAll());
        user = dao.user.read(user.getID());
    }
}
