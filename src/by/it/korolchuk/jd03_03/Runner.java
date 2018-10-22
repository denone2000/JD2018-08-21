package by.it.korolchuk.jd03_03;

import by.it.korolchuk.jd03_03.beans.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        List<User> users = dao.user.getAll();
        System.out.println(users);
    }
}
