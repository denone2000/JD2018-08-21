package by.it.voinilo.jd03.jd03_02.CRUD;

import by.it.voinilo.jd03.jd03_02.beans.Role;
import by.it.voinilo.jd03.jd03_02.beans.RoleParam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCrub {
    public boolean create(RoleParam role) throws SQLException {

        try (Connection connection = ConnectionCreater.getConnection();
             Statement statement = connection.createStatement()) {
            String sql =String.format("INSERT INTO `roles`(`role`) VALUES ('%s')", RoleParam.getRole());
            if(1 ==statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()){
                    int id = keys.getInt(1);
                    role.setId(id);
                    return true;
                }
            }
            return false;
        }

    }

    public boolean read(RoleParam roleParam){
        return false;
    }
    public boolean update(RoleParam roleParam){
        return false;
    }
    public boolean delete(RoleParam roleParam){
        return false;
    }
}
