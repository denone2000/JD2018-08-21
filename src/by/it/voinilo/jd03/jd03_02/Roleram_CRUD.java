package by.it.voinilo.jd03.jd03_02;

import by.it.voinilo.jd03.jd03_02.beans.Roleparam;
import by.it.voinilo.jd03.jd03_02.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Roleram_CRUD {
    static boolean create(Roleparam roleparam) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `roleparam`" +
                    "(`login`, `password`, `email`, `roles_id`)" +
                    " VALUES ('%s','%s','%s','%d');",
                    roleparam.getLogin(),roleparam.getPassword(),
                    roleparam.getEmail(), roleparam.getRoles_id());
            System.out.println(sql);
            if (statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roleparam.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Roleparam read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT `id`, `login`, `password`, `email`, `roles_id` FROM `roleparam` WHERE `id` = %d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Roleparam(
                resultSet.getLong("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getInt("roles_id"));
            }
            return null;
        }
    }

    static boolean update(Roleparam role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `roleparam` SET `login`='%s',`password`='%s'," +
                            "`email`='%s',`roles_id`='%d'" +
                            " WHERE `id`= %d",
                    role.getLogin(), role.getPassword(), role.getEmail(),
                    role.getRoles_id(),role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }


    static boolean delete(Roleparam role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `roleparam` WHERE `id` = %d",
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Roleparam role = new Roleparam(0,"log", "passwordddd", "email", 1 );
        if (create(role))
            System.out.println("create is ok: " + role );
        long id = role.getId();
        role = null;
        role = read(id);
        if (role!= null)
            System.out.println("read is ok: " + role);
       role.setLogin("==========================");
        if (update(role))
            System.out.println("Update is Ok: "+ role);
        if (delete(role))
            System.out.println("delete is ok: " + role);

    }
}

