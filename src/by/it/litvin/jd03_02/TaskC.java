package by.it.litvin.jd03_02;

import by.it.litvin.jd03_02.beans.Form;
import by.it.litvin.jd03_02.beans.Role;
import by.it.litvin.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    static void addRole(String role)throws SQLException{
        try (
                Connection connection=ConnectionCreator.getConnection();
                Statement statement=connection.createStatement()){
            Role role1=new Role(0,role);
            RoleCrud.create(role1);

        }
    }
    static void addUser(String login, String password, String email, long roles_id)throws SQLException{
        try (
                Connection connection=ConnectionCreator.getConnection();
                Statement statement=connection.createStatement()){
            User user=new User(0,login,password,email,2);
            UserCrud.create(user);

        }
    }
    static void addForm(String address,String description,int age, String information,String aim,long users_id)
            throws SQLException{
        try (
                Connection connection=ConnectionCreator.getConnection();
                Statement statement=connection.createStatement()){
            Form form=new Form(0,address,description,age,information,aim,2);
           FormCrud.create(form);

        }
    }
}
