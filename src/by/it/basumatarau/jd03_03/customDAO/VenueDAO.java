package by.it.basumatarau.jd03_03.customDAO;

import by.it.basumatarau.jd03_03.connection.ConnectionCreator;
import by.it.basumatarau.jd03_03.beans.Venue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VenueDAO extends DAO implements InterfaceDAO<Venue> {
    @Override
    public Venue read(long id) throws SQLException {
        List<Venue> result = getAll(String.format("WHERE `ID`=%d ;", id));  //"LIMIT 0,1 ;" why limit the query if the id is supposed to be unique?
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Venue bean) throws SQLException {
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        String sqlQuery = String.format("INSERT INTO `Venues`" +
                        "(`Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) " +
                        "VALUES ('%s','%s','%s',%s,%d,%d)",
                bean.getName(),
                bean.getDescription(),
                bean.getOpeningDeteTime(),
                nf.format(bean.getFee()),
                bean.getUsers_Id(),
                bean.getPlaces_Id()
        );
        long id;
        if((id=executeUpdate(sqlQuery))>0){
            bean.setId(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Venue bean) throws SQLException {
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        String sqlQuery = String.format("UPDATE `Venues` SET " +
                        "`Name`='%s'," +
                        "`Description`='%s'," +
                        "`OpeningDeteTime`='%s'," +
                        "`Fee`=%s," +
                        "`Users_ID`=%d," +
                        "`Places_ID`=%d " +
                        "WHERE `ID`=%d ;",
                bean.getName(),
                bean.getDescription(),
                bean.getOpeningDeteTime(),
                nf.format(bean.getFee()),
                bean.getUsers_Id(),
                bean.getPlaces_Id(),
                bean.getId()
        );
        
        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(Venue bean) throws SQLException {
        String sqlQuery = String.format("DELETE FROM `Venues` WHERE `ID`=%d",
                bean.getId()
        );
        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public List<Venue> getAll(String sqlWHERE) throws SQLException {
        List<Venue> result = new ArrayList<>();

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format("SELECT * FROM `Venues` %s ;", sqlWHERE);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
                result.add(
                        new Venue(resultSet.getLong("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                        resultSet.getTimestamp("OpeningDeteTime"),
                        resultSet.getFloat("Fee"),
                        resultSet.getLong("Users_ID"),
                        resultSet.getLong("Places_ID"))
                );
            }
        }
        return result;
    }
}
