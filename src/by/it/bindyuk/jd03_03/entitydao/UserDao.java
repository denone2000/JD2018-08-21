package by.it.bindyuk.jd03_03.entitydao;

import by.it.bindyuk.jd03_03.ConnectionCreator;
import by.it.bindyuk.jd03_03.InterfaceDAO;
import by.it.bindyuk.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao implements InterfaceDAO<User> {
    @Override
    public boolean create(User user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `passport series`," +
                            " `passport id`, `bancard number`, `cid`, `roles_id`) " +
                            "VALUES ('%s','%s','%s','%s','%d','%s','%d','%d');",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPasspostSeries(),
                    user.getPassportId(),
                    user.getBancardNumber(),
                    user.getCid(),
                    user.getRoles_id());

            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public User read(long id) {
        return null;
    }

    @Override
    public boolean update(User bean) {
        return false;
    }

    @Override
    public boolean delete(User bean) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAll(String where) {
        return null;
    }
}
