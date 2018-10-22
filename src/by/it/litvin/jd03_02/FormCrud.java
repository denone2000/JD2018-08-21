package by.it.litvin.jd03_02;

import by.it.litvin.jd03_02.beans.Form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormCrud {

    public static void main(String[] args) throws SQLException {

        Form form = new Form(3,"Minsk","Beautiful",16,"school girl",
                "friendship",2);
        if (create(form))
            System.out.println("Create " + form);
        long id = form.getId();
        form = read(id);
        if (form != null)
            System.out.println("Read " + form);
        form.setAddress("Grodno");
        if (update(form))
            System.out.println("Update " + form);
        if (delete(form))
            System.out.println("Delete " + form);
    }


    private static Form read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `form` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Form form = new Form(
                        resultSet.getLong("id"),
                        resultSet.getString("address"),
                        resultSet.getString("description"),
                        resultSet.getInt("age"),
                        resultSet.getString("information"),
                        resultSet.getString("aim"),
                        resultSet.getLong("users_id"));
                return form;
            }
        }return null;


    }

    static boolean update(Form form) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `form` SET " +
                            "`address`='%s'," +
                            "`description`='%s'," +
                            "`age`=%d," +
                            "`information`='%s'," +
                            "`aim`='%s'," +
                            "`users_id`=%d WHERE `id`=%d",
                    form.getAddress(),
                    form.getDescription(),
                    form.getAge(),
                    form.getInformation(),
                    form.getAim(),
                    form.getUsers_id(),
                    form.getId());
            System.out.println(sql);
            return (statement.executeUpdate(sql) == 1);
        }
    }

    private static boolean delete(Form form) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `form` WHERE `id`=%d",
                    form.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

     static boolean create(Form form) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "INSERT INTO `form`(`address`,`description`,`age`,`information`,`aim`,`users_id`)" +
                            " VALUES ('%s','%s',%d,'%s','%s',%d);",
                    form.getAddress(),
                    form.getDescription(),
                    form.getAge(),
                    form.getInformation(),
                    form.getAim(),
                    form.getUsers_id());
            System.out.println(sql);
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    form.setId(generatedKeys.getLong(1));
                    return true;
                }
            }

        }
        return false;

    }
}

