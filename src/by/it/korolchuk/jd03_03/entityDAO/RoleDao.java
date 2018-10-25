package by.it.korolchuk.jd03_03.entityDAO;


import by.it.korolchuk.jd03_03.ConnectionCreator;
import by.it.korolchuk.jd03_03.InterfaceDAO;
import by.it.korolchuk.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao implements InterfaceDAO<Role> {


    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO roles (role) values('%s');", role.getRole()
        );
        long id = executeUpdate(sql);
        if (id > 0) role.setId(id);
        return id > 0;
    }


    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE ID=" + id);
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }


    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET `Role` = '%s' WHERE `roles`.`id` = %d",
                role.getRole(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`ID` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return getAll("");
    }


    @Override
    public List<Role> getAll(String WHERE) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("ID"));
                role.setRole(rs.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }


}
