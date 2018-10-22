package by.it.galushka.jd03_02;

import by.it.galushka.jd03_02.beans.Car;
import by.it.galushka.jd03_02.beans.Order;
import by.it.galushka.jd03_02.beans.Role;
import by.it.galushka.jd03_02.beans.User;
import by.it.galushka.jd03_02.taskC.CreateDB;

import java.sql.SQLException;

public class TaskC {

    public static void main(String[] args) throws SQLException {
        CreateDB.createDB();
        Role role = new Role(0, "Administrator");
        RoleCRUD.createRole(role);
        role.setRole("User");
        RoleCRUD.createRole(role);
        User user = new User(0, "admin", "qwerty", "admin@it.by", 1);
        if (UserCRUD.create(user))
            System.out.println("Create OK: " + user);
        user = new User(0, "user", "qwerty", "user@it.by", 2);
        if (UserCRUD.create(user))
            System.out.println("Create OK: " + user);
        Car car = new Car(0, "Opel", "Astra", "Red", 1.8,
                "1991/10/11", 1);
        if (CarCRUD.create(car))
            System.out.println("Create OK: " + car);
        Order order = new Order(0, "jfkgl5o6hj7nck", "2018/10/01", "2019/01/01",
                "Petrov", "Petr", "Petrovich", "Sovetskaya, 10", 2);
        if (OrderCRUD.create(order))
            System.out.println("Create OK: " + order);
//=================For reset all DB===================
//        Reset.reset();
    }
}
