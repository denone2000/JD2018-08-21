package by.it.litvin.jd03_03;

import by.it.litvin.jd03_03.beans.Form;
import by.it.litvin.jd03_03.beans.Role;
import by.it.litvin.jd03_03.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        User user = new User(0, "EdwardDao", "EdwardDao", "EdwardDao@mail.ru", 2);
        if (dao.user.create(user))
            System.out.println("Users is created " + user);
       user=dao.user.read(user.getId());
        System.out.println("Read "+user.getPassword());
        user.setLogin("edward");
        if (dao.user.update(user))
            System.out.println("User is changed " + user);
        if (dao.user.delete(user))
            System.out.println("User is deleted");

        Role role=new Role(0,"RoleDao");
        if (dao.role.create(role))
            System.out.println("Role is created "+ role);
        role=dao.role.read(role.getId());
        role.setRole("qwerty1");
        if (dao.role.update(role))
            System.out.println("Role is changed "+role);

        Form form = new Form(0,"Sasha","Zankovich","Minsk","beautifull",19,
                "student","friendship",2);
//        form.setDescription("old");
//        form.setAge(20);
//        form.setUsers_id(2);
        if (dao.form.create(form))
            System.out.println("Form is created " + form);
        form=dao.form.read(form.getId());
        System.out.println("Form is readed "+form.getAge());
        form.setDescription("not old");
        if (dao.form.update(form))
            System.out.println("Form is updated " + form);
//        if (dao.form.delete(form))
//            System.out.println("Form is deleted "+form);
//        dao.reset();



    }
}
