package by.it.galushka.jd03_03;

import by.it.galushka.jd03_03.beans.*;


import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {

        String line = "=============================================";

        Dao dao = Dao.getDao();

        //User test===========================================
        User user = new User(0, "UserDao", "UserDao",
                "UserDao@user.ru", 2);
        if (dao.user.create(user))
            System.out.println("CREATE:\n" + dao.user.getAll() + '\n');
        System.out.println("READ:\n" + dao.user.read(user.getID()) + '\n');
        user = dao.user.read(user.getID());
        user.setLogin("uuuuuu");
        if (dao.user.update(user))
            System.out.println("UPDATE:\n" + dao.user.getAll() + '\n');
        if (dao.user.delete(user))
            System.out.println("DELETE:\n" + dao.user.getAll() + '\n');
        System.out.println(line);

//        //Role test===========================================
        Role role = new Role(0, "DaoRole");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getAll());
        System.out.println("READ:\n" + dao.role.read(role.getID()) + '\n');
        role = dao.role.read(role.getID());
        role.setRole("rrrrrrrrrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getAll() + '\n');
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getAll() + '\n');
        System.out.println(line);

        //Car test===========================================
        Car car = new Car(0,"Opel", "Astra", "Black",
                1.8, "1999/10/19", 1);
        if (dao.car.create(car))
            System.out.println("CREATE:\n" + dao.car.getAll());
        System.out.println("READ:\n" + dao.car.read(car.getID()) + '\n');
        car = dao.car.read(car.getID());
        car.setColor("GGGGGoldenGGGGGGGold");
        if (dao.car.update(car))
            System.out.println("UPDATE:\n" + dao.car.getAll() + '\n');
        if (dao.car.delete(car))
            System.out.println("DELETE:\n" + dao.car.getAll() + '\n');
        System.out.println(line);

        //Order test===========================================
        Order order = new Order(0,"387239H987PB91","2017/01/01",
                "2018/12/31","Pupkin","Valeryj","Nikolaevich", "Krasnaya 17",3);
        if (dao.order.create(order))
            System.out.println("CREATE:\n" + dao.order.getAll());
        System.out.println("READ:\n" + dao.order.read(order.getID()) + '\n');
        order = dao.order.read(order.getID());
        order.setReturnDate("2019/03/16");
        if (dao.order.update(order))
            System.out.println("UPDATE:\n" + dao.order.getAll() + '\n');
        if (dao.order.delete(order))
            System.out.println("DELETE:\n" + dao.order.getAll() + '\n');
        System.out.println(line);
    }
}
