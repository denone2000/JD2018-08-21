package by.it.galushka.jd03_03.dao;

import by.it.galushka.jd03_03.ConnectionCreator;
import by.it.galushka.jd03_03.InterfaceDao;
import by.it.galushka.jd03_03.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends AbstractDao implements InterfaceDao<Car> {

    @Override
    public boolean create(Car car) throws SQLException {
        String sql = String.format("INSERT INTO `cars`(`Mark`, `Model`, " +
                        "`Color`, `Engine capacity`, " +
                        "`Release date`, `users_ID`) VALUES (" +
                        "'%s','%s','%s','%f','%s','%d')",
                car.getMark(),
                car.getModel(),
                car.getColor(),
                car.getEngineCapacity(),
                car.getReleaseDate(),
                car.getUsers_ID());
        long id = executeUpdate(sql);
        if (id > 0) {
            car.setID(id);
        }
        return (id > 0);
    }

    @Override
    public Car read(long id) throws SQLException {
        List<Car> cars = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (cars.size() > 0) {
            return cars.get(0);
        }
        return null;
    }

    @Override
    public boolean update(Car car) throws SQLException {
        String sql = String.format("UPDATE `cars` SET `Mark`='%s',`Model`='%s',`Color`='%s'," +
                        "`Engine capacity`=%f,`Release date`='%s',`users_ID`=%d WHERE `ID`=%d",
                car.getMark(),
                car.getModel(),
                car.getColor(),
                car.getEngineCapacity(),
                car.getReleaseDate(),
                car.getUsers_ID(),
                car.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Car car) throws SQLException {
        String sql = String.format("DELETE FROM `cars` WHERE `ID`=%d",
                car.getID());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Car> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Car> getAll(String WhereAndOrder) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSetCars = statement.executeQuery(sql);
            while (resultSetCars.next()) {
                Car car = new Car();
                car.setID(resultSetCars.getLong("ID"));
                car.setMark(resultSetCars.getString("Mark"));
                car.setModel(resultSetCars.getString("Model"));
                car.setColor(resultSetCars.getString("Color"));
                car.setEngineCapacity(resultSetCars.getDouble("Engine capacity"));
                car.setReleaseDate(resultSetCars.getString("Release date"));
                car.setUsers_ID(resultSetCars.getLong("users_ID"));
                cars.add(car);
            }
            return cars;
        }
    }
}
