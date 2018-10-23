package by.it.basumatarau.jd03_02.crud;

import by.it.basumatarau.jd03_02.ConnectionCreator;
import by.it.basumatarau.jd03_02.beans.Venue;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

public class VenueCRUD {
    public static boolean create(Venue venue) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
            String sqlQuery = String.format("INSERT INTO `Venues`" +
                    "(`Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) " +
                    "VALUES ('%s','%s','%s',%s,%d,%d)",
                    venue.getName(),
                    venue.getDescription(),
                    venue.getOpeningDateTime(),
                    nf.format(venue.getFee()),
                    venue.getUsers_ID(),
                    venue.getPlace_ID()
            );
            statement.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                venue.setId(generatedKeys.getLong(1));
                return true;
            }
        }
        return false;
    }
    static Venue read(long id) throws SQLException{
        Venue venue = null;
        try(Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sqlQuery = String.format("SELECT * FROM `Venues` WHERE `ID`=%d", id);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()){
                venue = new Venue(resultSet.getLong("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                        resultSet.getTimestamp("OpeningDeteTime"),
                        resultSet.getFloat("Fee"),
                        resultSet.getLong("Users_ID"),
                        resultSet.getLong("Places_ID")
                );
            }
        }
        return venue;
    }
    static boolean update(Venue venue) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
            String sqlQuery = String.format("UPDATE `Venues` SET " +
                    "`Name`='%s'," +
                    "`Description`='%s'," +
                    "`OpeningDeteTime`='%s'," +
                    "`Fee`=%s," +
                    "`Users_ID`=%d," +
                    "`Places_ID`=%d " +
                    "WHERE `ID`=%d ;",
                    venue.getName(),
                    venue.getDescription(),
                    venue.getOpeningDateTime(),
                    nf.format(venue.getFee()),
                    venue.getUsers_ID(),
                    venue.getPlace_ID(),
                    venue.getId()
            );
            return statement.executeUpdate(sqlQuery)==1;
        }
    }
    static boolean delete(Venue venue) throws SQLException{
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format("DELETE FROM `Venues` WHERE `ID`=%d",venue.getId());

            return statement.executeUpdate(sqlQuery)==1;
        }
    }

    public static void main(String[] args) throws SQLException{

        Venue venue = new Venue(99,
                "test venue name",
                "test venue description",
                new Timestamp(999999999999L),
                5.5f,
                2,
                2);

        if(create(venue))
            System.out.println("created :"+venue);
        System.out.println(read(venue.getId()));

        venue.setOpeningDateTime(new Timestamp(999999999999L+199999999999L));
        if(update(venue))
            System.out.println("updated: "+ venue);
        System.out.println(read(venue.getId()));
        if(delete(venue))
            System.out.println("deleted: "+venue);

    }
}
