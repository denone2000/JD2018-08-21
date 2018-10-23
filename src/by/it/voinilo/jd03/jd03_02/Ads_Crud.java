package by.it.voinilo.jd03.jd03_02;

import by.it.voinilo.jd03.jd03_02.beans.Ads;
import by.it.voinilo.jd03.jd03_02.beans.Roleparam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ads_Crud {
    static boolean create(Ads ads) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `ads`(`description`," +
                            " `address`, `name`, `price`, `condition`," +
                            " `cellnumber`, `roles_id`) VALUES ('%s','%s','%s','%s','%s','%s','%d')",
                    ads.getDescription(),ads.getAddress(),ads.getName(),ads.getPrice(),
                    ads.getCondition(),ads.getCellnumber(), ads.getRoles_id());
            System.out.println(sql);
            if (statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ads.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    static Ads read(long id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT `id`, `description`, `address`, `name`, `price`, `condition`, `cellnumber`, `roles_id` FROM `ads` WHERE `id` = %d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Ads(
                resultSet.getLong("id"),
                resultSet.getString("description"),
                resultSet.getString("address"),
                resultSet.getString("name"),
                resultSet.getString("price"),
                resultSet.getString("condition"),
                resultSet.getString("cellnumber"),
                resultSet.getInt("roles_id"));
            }
            return null;
        }
    }

    static boolean update(Ads ads) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `ads` SET `description`='%s'," +
                            "`address`='%s',`name`='%s',`price`='%s'," +
                            "`condition`='%s',`cellnumber`='%s',`roles_id`='%d' WHERE `id`= %d",
                    ads.getDescription(),ads.getAddress(),ads.getName(),ads.getPrice(),
                    ads.getCondition(),ads.getCellnumber(), ads.getRoles_id(),ads.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }


    static boolean delete(Ads ads) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `ads` WHERE `id` = %d",
                    ads.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    public static void main(String[] args) throws SQLException {
        Ads ads = new Ads(0,"well-worn nokia 3310",
                "Makayonka 9", "Продам nokia 3310","5000$",
                "battle-scared", "+375291112233" ,1 );
        if (create(ads))
            System.out.println("create is ok: " + ads );
        long id = ads.getId();
        ads = null;
        ads = read(id);
        if (ads!= null)
            System.out.println("read is ok: " + ads);
       ads.setCellnumber("==========================");
        if (update(ads))
            System.out.println("Update is Ok: "+ ads);
        if (delete(ads))
            System.out.println("delete is ok: " + ads);

    }
}

