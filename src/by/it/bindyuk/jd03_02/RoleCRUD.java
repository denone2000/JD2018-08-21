package by.it.bindyuk.jd03_02;

import by.it.bindyuk.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    boolean create(User user) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
//            String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `roles_id`) " +
//                    "VALUES ('%s','%s','%s','%d'); +
//                    "user.getLogin(), user.getPassword()," +
//                    " user.getEmail(), user.getRolesId());
//            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
//                ResultSet generateKeys = statement.getGeneratedKeys();
//                if (generateKeys.next()) {
//                    user.setId(generateKeys.getLong(1));
//                    return true;
//                }
           // }
        }
        return false;

    }

}
