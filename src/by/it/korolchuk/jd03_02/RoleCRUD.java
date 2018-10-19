package by.it.korolchuk.jd03_02;

import by.it.korolchuk.jd03_02.beans.User;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    public RoleCRUD(){
    }


    static boolean create (User user)  throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `users`(`login`, `password`, `email`, `roles_id`) " +
                            "VALUES ('%s','%s','%s',%d)",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRolesId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
                return  true;
            }
        }
        return false;
    }




    static boolean update (User user)  throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `users` SET " +
                            "`login`='%s'," +
                            "`password`='%s'," +
                            "`email`='%s'," +
                            "`roles_id`=%d WHERE `id`=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRolesId());
                    user.getId();
            if (statement.executeUpdate(sql)==1){
                return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        User user = new User(0, "loginjava", "qwerty", "aaaa@aaa.aa", 2);
        if (create(user)) {
            System.out.println("Created OK: " + user);
            user.setEmail("bbbb@bbb.bb");
        }
           if (update(user)) {
                System.out.println("Updated OK: " + user);
            }
        }
    }

