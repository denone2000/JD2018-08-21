package by.it.korolchuk.jd03_03.entityDAO;


import by.it.korolchuk.jd03_03.ConnectionCreator;
import by.it.korolchuk.jd03_03.InterfaceDAO;
import by.it.korolchuk.jd03_03.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDao extends AbstractDao implements InterfaceDAO<Ad> {


    @Override
    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(
                "INSERT INTO `ads`(`id`,`description`, `kindOfAnimal`, `greed`, `sex`, `age`, `height`, `qualities`, `users_id`) " +
                        "VALUES (%d,'%s','%s','%s', '%s', %d, %d, '%s', %d)",
                ad.getId(),
                ad.getDescription(),
                ad.getKindOfAnimal(),
                ad.getGreed(),
                ad.getSex(),
                ad.getAge(),
                ad.getHeight(),
                ad.getQalities(),
                ad.getUsersId());

        long id = executeUpdate(sql);
        if (id > 0) ad.setId(id);
        return id > 0;
    }


    @Override
    public Ad read(long id) throws SQLException {
        List<Ad> ads = getAll("WHERE ID=" + id);
        if (ads.size() > 0) {
            return ads.get(0);
        } else
            return null;
    }


    @Override
    public boolean update(Ad ad) throws SQLException {
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
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        String sql = String.format(
                "DELETE FROM `ads` WHERE `ads`.`id` = %d;", ad.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll() throws SQLException {
        return getAll("");
    }


    @Override
    public List<Ad> getAll(String WHERE) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ads " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getString("kindOfAnimal"),
                        rs.getString("greed"),
                        rs.getString("sex"),
                        rs.getLong("age"),
                        rs.getLong("height"),
                        rs.getString("qualities"),
                        rs.getLong("users_id")));
            }
        }
        return ads;
    }

}
