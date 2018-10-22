package by.it.voinilo.jd03.jd03_02;

import by.it.voinilo.jd03.jd03_02.beans.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Roles_CRUD {
    static boolean create(Roles roles) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `roles`(`role`) " +
                    "VALUES ('%s');", roles.getRole());
            System.out.println(sql);
            if (statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roles.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Roles read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` " +
                    "WHERE `id`= %d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Roles(
                resultSet.getLong("id"),
                resultSet.getString("role"));
            }
            return null;
        }
    }

    static boolean update(Roles role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `roles` SET " +
                            "`role`='%s' WHERE `id` = %d",
                    role.getRole(), role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }


    static boolean delete(Roles role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `roles` WHERE `id` = %d",
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Roles role = new Roles(0, "sup");
        if (create(role))
            System.out.println("create is ok: " + role );
        long id = role.getId();
        role = null;
        role = read(id);
        if (role!= null)
            System.out.println("read is ok: " + role);
       role.setRole("sup2");
        if (update(role))
            System.out.println("Update is Ok: "+ role);
        if (delete(role))
            System.out.println("delete is ok: " + role);

    }
}

