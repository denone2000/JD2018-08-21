package by.it.basumatarau.jd03_03.customDAO;

import by.it.basumatarau.jd03_03.connection.ConnectionCreator;
import by.it.basumatarau.jd03_03.beans.Place;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAO extends DAO implements InterfaceDAO<Place> {
    @Override
    public Place read(long id) throws SQLException {
        List<Place> result = getAll(String.format("WHERE `ID`=%d", id));
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Place bean) throws SQLException {
        String sqlQuery = String.format("INSERT INTO `Places`(`Name`, `Address`) " +
                        "VALUES ('%s','%s')",
                bean.getName(),
                bean.getAddress()
        );
        long id;
        if((id=executeUpdate(sqlQuery))>0){
            bean.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Place bean) throws SQLException {
        String sqlQuery = String.format("UPDATE `Places` SET " +
                        "`Name`='%s',`Address`='%s' " +
                        "WHERE `ID`=%d",
                bean.getName(),
                bean.getAddress(),
                bean.getId());

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(Place bean) throws SQLException {
        String sqlQuery = String.format("DELETE FROM `Places` WHERE `ID`=%d",
                bean.getId()
        );
        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public List<Place> getAll(String sqlWHERE) throws SQLException {
        List<Place> result = new ArrayList<>();
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sqlQuery = String.format("SELECT * FROM `Places` %s ;",
                    sqlWHERE
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                result.add(
                        new Place(
                        resultSet.getLong("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Address"))
                );
            }
        }
        return result;
    }
}
