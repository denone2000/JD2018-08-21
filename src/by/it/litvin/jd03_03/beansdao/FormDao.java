package by.it.litvin.jd03_03.beansdao;

import by.it.litvin.jd03_03.InterfaceDao;
import by.it.litvin.jd03_03.beans.Form;
import by.it.litvin.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormDao extends AbstractDao implements InterfaceDao<Form> {
    @Override
    public Form read(long id) throws SQLException {
        List<Form> forms = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (forms.size() > 0) {
            return forms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Form form) throws SQLException {
        String sql = String.format(
                "INSERT INTO `form`(`name`,`surname`,`address`,`description`,`age`,`information`,`aim`,`users_id`)" +
                        " VALUES ('%s','%s','%s','%s',%d,'%s','%s',%d);",
                form.getName(),
                form.getSurname(),
                form.getAddress(),
                form.getDescription(),
                form.getAge(),
                form.getInformation(),
                form.getAim(),
                form.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) form.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Form form) throws SQLException {
        String sql = String.format(
                "UPDATE `form` SET " +
                        "`name`='%s'," +
                        "`surname`='%s'," +
                        "`address`='%s'," +
                        "`description`='%s'," +
                        "`age`=%d," +
                        "`information`='%s'," +
                        "`aim`='%s'," +
                        "`users_id`=%d WHERE `id`=%d",
                form.getName(),
                form.getSurname(),
                form.getAddress(),
                form.getDescription(),
                form.getAge(),
                form.getInformation(),
                form.getAim(),
                form.getUsers_id(),
                form.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Form form) throws SQLException {
        String sql = String.format(
                "DELETE FROM `form` WHERE `id`=%d", form.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Form> getAll(String WHERE) throws SQLException {
        List<Form> forms = new ArrayList<>();
        String sql = "SELECT * FROM `form`" + WHERE + ";";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Form form=new Form();
                form.setId(resultSet.getLong("id"));
                form.setName(resultSet.getString("name"));
                form.setSurname(resultSet.getString("surname"));
                form.setAddress(resultSet.getString("address"));
                form.setDescription(resultSet.getString("description"));
                form.setAge(resultSet.getInt("age"));
                form.setInformation(resultSet.getString("information"));
                form.setAim(resultSet.getString("aim"));
                form.setUsers_id(resultSet.getLong("users_id"));
                forms.add(form);
            }
            return forms;
        }
    }
}