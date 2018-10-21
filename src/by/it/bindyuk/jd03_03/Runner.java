package by.it.bindyuk.jd03_03;

import by.it.bindyuk.jd03_03.beans.User;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Dao dao = Dao.getDao();
        List<User> all = dao.user.getAll();
    }
}
