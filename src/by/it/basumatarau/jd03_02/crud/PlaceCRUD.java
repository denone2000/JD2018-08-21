package by.it.basumatarau.jd03_02.crud;

import by.it.basumatarau.jd03_02.ConnectionCreator;
import by.it.basumatarau.jd03_02.beans.Place;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaceCRUD {
    public static boolean create(Place place) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("INSERT INTO `Places`(`Name`, `Address`) " +
                            "VALUES ('%s','%s')",
                    place.getName(),
                    place.getAddress()
            );
            statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                place.setId(generatedKeys.getLong(1));
                return true;
            }
        }
        return false;
    }
    static Place read(long id) throws SQLException{
        Place place = null;
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("SELECT * FROM `Places` WHERE `ID`=%d",
                    id
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                place=new Place(
                        resultSet.getLong("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Address")
                );
            }
        }
        return place;
    }
    static boolean update(Place place) throws SQLException{
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("UPDATE `Places` SET " +
                    "`Name`='%s',`Address`='%s' " +
                    "WHERE `ID`=%d",
                    place.getName(),
                    place.getAddress(),
                    place.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }

    }
    static boolean delete(Place place) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("DELETE FROM `Places` WHERE `ID`=%d", place.getId());
            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    public static void main(String[] args) throws SQLException{
        Place u = new Place(99,"aaaaa","asdf");
        create(u);
        System.out.println(read(u.getId()));
        u.setName("qqqq");
        update(u);
        System.out.println(read(u.getId()));
        delete(u);
    }
}
