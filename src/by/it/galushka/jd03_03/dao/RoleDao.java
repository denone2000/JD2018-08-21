package by.it.galushka.jd03_03.dao;


import by.it.galushka.jd03_03.ConnectionCreator;
import by.it.galushka.jd03_03.InterfaceDao;
import by.it.galushka.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDao<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`Role`) " +
                "VALUES ('%s');", role.getRole());
        long id = executeUpdate(sql);
        if (id > 0) {
            role.setID(id);
        }
        return id > 0;
    }

    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        }else
            return null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `Role`='%s' " +
                "WHERE `ID`=%d", role.getRole(), role.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `roles` WHERE `ID`=%d", role.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSetRoles = statement.executeQuery(sql);
            while (resultSetRoles.next()) {
                Role role = new Role();
                role.setID(resultSetRoles.getInt("ID"));
                role.setRole(resultSetRoles.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
