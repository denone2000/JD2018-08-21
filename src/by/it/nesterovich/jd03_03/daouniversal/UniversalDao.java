package by.it.nesterovich.jd03_03.daouniversal;

import by.it.nesterovich.jd03_03.ulils.ConnectionCreator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UniversalDao<TypeBean> implements InterfaceDao<TypeBean> {

    private TypeBean bean;
    private String table;
    private Field[] fields;

    public UniversalDao(TypeBean bean, String sqlTableName) {
        this.bean = bean;
        this.table = sqlTableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    @Override
    public boolean create(TypeBean entity) throws SQLException {
        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                names.append(fields[i].getName()).append(',');
                values.append(String.format("'%s',", fields[i].get(entity)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        names.deleteCharAt(names.length() - 1);
        values.deleteCharAt(values.length() - 1);
        String sql = String.format("INSERT INTO `%s` (%s) VALUES (%s);", table, names, values);
        long result = executeUpdate(sql);
        if (result > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(entity, result);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TypeBean read(int id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        return (beans.size() > 0) ? beans.get(0) : null;
    }

    @Override
    public boolean update(TypeBean entity) throws SQLException {
        StringBuilder line = new StringBuilder();
        long id = 0;
        try {
            fields[0].setAccessible(true);
            id = (long) fields[0].get(entity);
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                line.append(String.format("%s='%s',", fields[i].getName(), fields[i].get(entity)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        line.deleteCharAt(line.length() - 1);
        String sql = String.format("UPDATE `%s` SET %s WHERE %s.id='%d';", table, line, table, id);
        return executeUpdate(sql) == 1;
    }

    @Override
    public boolean delete(TypeBean entity) throws SQLException {
        fields[0].setAccessible(true);
        String sql = null;
        try {
            sql = String.format("DELETE FROM %s WHERE id=%s;", table, fields[0].get(entity));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return executeUpdate(sql) == 1;
    }

    @Override
    public List<TypeBean> getAll(String whereAndOrder) throws SQLException {
        List<TypeBean> list = new ArrayList<>();
        String query = String.format("SELECT * FROM %s %s", table, whereAndOrder);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                TypeBean newBean = newBean();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String strType = field.getType().toString();
                    try {
                        if (field.getType() == Boolean.class || strType.equals("boolean")) {
                            field.set(newBean, resultSet.getBoolean(field.getName()));
                        }
                        if (field.getType() == Byte.class || strType.equals("byte")) {
                            field.set(newBean, resultSet.getByte(field.getName()));
                        }
                        if (field.getType() == Integer.class || strType.equals("int")) {
                            field.set(newBean, resultSet.getInt(field.getName()));
                        }
                        if (field.getType() == Double.class || strType.equals("double")) {
                            field.set(newBean, resultSet.getDouble(field.getName()));
                        }
                        if (field.getType() == Float.class || strType.equals("float")) {
                            field.set(newBean, resultSet.getFloat(field.getName()));
                        }
                        if (field.getType() == Long.class || strType.equals("long")) {
                            field.set(newBean, resultSet.getLong(field.getName()));
                        }
                        if (field.getType() == Short.class || strType.equals("short")) {
                            field.set(newBean, resultSet.getShort(field.getName()));
                        }
                        if (field.getType() == String.class) {
                            field.set(newBean, resultSet.getString(field.getName()));
                        }
                        if (field.getType() == Date.class) {
                            field.set(newBean, resultSet.getDate(field.getName()));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                list.add(newBean);
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private TypeBean newBean() {
        try {
            return (TypeBean) bean.getClass().getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private long executeUpdate(String sql) {
        long result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            }
        } catch (Exception e) {
            //тут нужно логгирование SQLException(e);
            e.printStackTrace();
        }
        //System.out.println(result + ":" + sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}
