package by.it.korolchuk.jd03_02;

import by.it.korolchuk.jd03_02.beans.Ad;
import by.it.korolchuk.jd03_02.beans.Role;
import by.it.korolchuk.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdCRUD {

    static boolean create (Ad ad)  throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `ads`(`description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                            "VALUES ('%s', '%s', '%s', '%s', %d, %d, '%s', %d)",
                    ad.getDescription(),
                    ad.getKindOfAnimal(),
                    ad.getGreed(),
                    ad.getSex(),
                    ad.getAge(),
                    ad.getHeight(),
                    ad.getQalities(),
                    ad.getUsersId());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ad.setId(generatedKeys.getLong(1));
                }
                return  true;
            }
        }
        return false;
    }


    static Ad read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `Ads` WHERE `id`=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Ad(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("kindOfAnimal"),
                        resultSet.getString("greed"),
                        resultSet.getString("sex"),
                        resultSet.getLong("age"),
                        resultSet.getLong("height"),
                        resultSet.getString("qualities"),
                        resultSet.getLong("users_id"));
            }
            return null;
        }
    }


    static boolean update (Ad ad)  throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `ads` SET " +
                            "`description`='%s'," +
                            "`kindOfAnimal`='%s'," +
                            "`greed`='%s'," +
                            "`sex`='%s'," +
                            "`age`=%d," +
                            "`height`=%d," +
                            "`qualities`='%s'," +
                            "`users_id`=%d WHERE `id`=%d",
                    ad.getDescription(),
                    ad.getKindOfAnimal(),
                    ad.getGreed(),
                    ad.getSex(),
                    ad.getAge(),
                    ad.getHeight(),
                    ad.getQalities(),
                    ad.getUsersId(),
                    ad.getId());
            if (statement.executeUpdate(sql)==1){
                return  true;
            }
        }
        return false;
    }


    static boolean delete(Ad ad) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "DELETE FROM `Ads` WHERE `id`=%d",
                    ad.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Ad ad = new Ad(0, "some dog", "a dog", "husky", "male", 12, 54, "bold", 2);
        if (create(ad)) {
            System.out.println("Create OK: " + ad);
        }
        long id = ad.getId();
        ad = null;
        ad = read(id);
        if (ad != null) System.out.println("Read OK: " + ad);
        if (ad != null) ad.setQalities("shy");
        if (ad != null && update(ad)) System.out.println("Update OK: " + ad);
        if (ad != null && delete(ad)) System.out.println("Delete OK: " + ad);
    }
}

