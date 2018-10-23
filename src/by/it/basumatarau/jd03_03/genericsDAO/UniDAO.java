package by.it.basumatarau.jd03_03.genericsDAO;
import by.it.basumatarau.jd03_03.connection.ConnectionCreator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.*;

public class UniDAO<T> implements InterfaceDAO<T>{

    private static Set<UniDAO> UniDAOMonitorsPool = new HashSet<>();

    private Class<T> bean;
    private String sqlTbale;
    private Field[] fields;

    private UniDAO(){
    }

    synchronized public static UniDAO getDAO(Class bean, String sqlTableName){

        for (UniDAO dao : UniDAOMonitorsPool) {
            if(dao.sqlTbale.toLowerCase().equals(sqlTableName)){
                return dao;
            }
        }

        UniDAO uniDAO = new UniDAO();
        uniDAO.bean=bean;
        uniDAO.sqlTbale=sqlTableName;
        uniDAO.fields=bean.getDeclaredFields();

        UniDAOMonitorsPool.add(uniDAO);
        return uniDAO;
    }

    private long executeUpdate(String sqlStatement) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()
        ){

            if(sqlStatement.toLowerCase().matches("^\\s*insert.*")) {
                if (statement.executeUpdate(sqlStatement, Statement.RETURN_GENERATED_KEYS) == 1) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    }
                }
            }else{
                return statement.executeUpdate(sqlStatement);
            }
        }
        return -1;
    }

    @Override
    public T read(long id) throws SQLException {
        List<T> result = getAll(String.format("WHERE `ID`=%d", id));
        if(result.size()>0){
            return result.get(0);
        }else{
            return null;
        }
    }

    @Override
    public boolean create(T bean) throws SQLException {

        StringBuilder columnNames= new StringBuilder();
        StringBuilder values=new StringBuilder();
        String delimiter="";

        for (int i = 1; i < fields.length+1; i++) {

            Field f = fields[i-1];

            //skip ID column if it has autoincrement property
            if(f.getName().toLowerCase().equals("id")){
                continue;
            }

            f.setAccessible(true);
            String strftype = f.getType().toString();

            try {
                if(f.getType()==Boolean.class || strftype.equals("boolean")) {
                    values.append(delimiter).append(
                            String.format("'%s'", f.getBoolean(bean)))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Byte.class || strftype.equals("byte")){
                    values.append(delimiter).append(
                            String.format("%d", f.getByte(bean)))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Integer.class || strftype.equals("int")){
                    values.append(delimiter).append(
                            String.format("%d", f.getInt(bean)))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Long.class || strftype.equals("long")){
                    values.append(delimiter).append(
                            String.format("%d", f.getLong(bean)))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Double.class || strftype.equals("double")){
                    NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
                    values.append(delimiter).append(
                            String.format("%s", nf.format(f.getDouble(bean))))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Float.class || strftype.equals("float")){
                    NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
                    values.append(delimiter).append(
                            String.format("%s", nf.format(f.getFloat(bean))))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Short.class || strftype.equals("short")){
                    values.append(delimiter).append(
                            String.format("%d", f.getShort(bean)))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==String.class){
                    values.append(delimiter).append(
                            String.format("'%s'", f.get(bean).toString()))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()== Timestamp.class){
                    values.append(delimiter).append(
                            String.format("'%s'", f.get(bean).toString()))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                if(f.getType()==Date.class){
                    values.append(delimiter).append(
                            String.format("'%s'", f.get(bean).toString()))
                    ;
                    columnNames.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    );
                }
                delimiter=", ";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String sqlQuery = String.format("INSERT INTO `%s` (%s) VALUES (%s) ;" ,
                sqlTbale,
                columnNames,
                values
        );
        System.out.println(sqlQuery);

        long id;
        if((id=executeUpdate(sqlQuery))>0) {
            Method idSetter;
            String idFieldName="";
            try {
                for (Field field : fields) {
                    if(field.getName().toLowerCase().equals("id")){
                        idFieldName=field.getName();
                        break;
                    }
                }
                idSetter = this.bean.getDeclaredMethod("set"+
                                idFieldName.substring(0,1).toUpperCase()+idFieldName.substring(1), Long.TYPE);
                idSetter.invoke(bean, id);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return true;
        }else
            return false;
    }

    @Override
    public boolean update(T bean) throws SQLException {

        StringBuilder setOfPairs= new StringBuilder();
        String delimiter="";

        for (int i = 1; i < fields.length+1; i++) {

            Field f = fields[i-1];

            //skip ID column if it has autoincrement property
            if(f.getName().toLowerCase().equals("id")){
                continue;
            }

            f.setAccessible(true);
            String strftype = f.getType().toString();

            try {
                if(f.getType()==Boolean.class || strftype.equals("boolean")) {
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%s", f.getBoolean(bean))
                    );
                }
                if(f.getType()==Byte.class || strftype.equals("byte")){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%d", f.getByte(bean))
                    );
                }
                if(f.getType()==Integer.class || strftype.equals("int")){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%d", f.getInt(bean))
                    );
                }
                if(f.getType()==Long.class || strftype.equals("long")){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%d", f.getLong(bean))
                    );
                }
                if(f.getType()==Double.class || strftype.equals("double")){
                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
                    nf.setGroupingUsed(false);
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%s", nf.format(f.getDouble(bean)))
                    );
                }
                if(f.getType()==Float.class || strftype.equals("float")){
                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
                    nf.setGroupingUsed(false);
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%s", nf.format(f.getFloat(bean)))
                    );
                }
                if(f.getType()==Short.class || strftype.equals("short")){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%d", f.getShort(bean))
                    );
                }
                if(f.getType()==String.class){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("'%s'", f.get(bean).toString())
                    );
                }
                if(f.getType()== Timestamp.class){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("'%s'", f.get(bean).toString())
                    );
                }
                if(f.getType()==Date.class){
                    setOfPairs.append(delimiter).append(
                            String.format("`%s`", f.getName())
                    ).append("=").append(
                            String.format("%s", f.get(bean).toString())
                    );
                }
                delimiter=",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Method idGetter;
        String idFieldName="";
        Long id=0L;
        try {
            for (Field field : fields) {
                if(field.getName().toLowerCase().equals("id")){
                    idFieldName=field.getName();
                    break;
                }
            }
            idGetter = this.bean.getDeclaredMethod("get"+
                    idFieldName.substring(0,1).toUpperCase()+idFieldName.substring(1));
            id = (Long)idGetter.invoke(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String sqlQuery = String.format("UPDATE `%s` SET %s " +
                        "WHERE `ID`= %d ;",
                sqlTbale,
                setOfPairs,
                id
        );
        //System.out.println(sqlQuery);

        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(T bean) throws SQLException {
        Method idGetter;
        String idFieldName="";
        Long id=0L;
        try {
            for (Field field : fields) {
                if(field.getName().toLowerCase().equals("id")){
                    idFieldName=field.getName();
                    break;
                }
            }
            idGetter = this.bean.getDeclaredMethod("get"+
                    idFieldName.substring(0,1).toUpperCase()+idFieldName.substring(1));
            id = (Long)idGetter.invoke(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String sqlQuery = String.format("DELETE FROM `%s` WHERE `ID`=%d",
                sqlTbale,
                id
        );

        System.out.println(sqlQuery);

        return executeUpdate(sqlQuery)==1;
    }
    @Override
    public List<T> getAll(String sqlWHEREStatement) throws SQLException{
        List<T> result = new ArrayList<>();
        String sqlQuery = String.format("SELECT * FROM %s %s ;",
                this.sqlTbale,
                sqlWHEREStatement
        );
        try(Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
                T newBean = null;
                try {
                    newBean = bean.newInstance();

                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i < fields.length+1; i++) {
                    Field f = fields[i-1];
                    f.setAccessible(true);
                    String strftype = f.getType().toString();
                    try {
                        if(f.getType()==Boolean.class || strftype.equals("boolean")) {
                            f.set(newBean, resultSet.getBoolean(i));
                        }
                        if(f.getType()==Byte.class || strftype.equals("byte")){
                            f.set(newBean, resultSet.getByte(i));
                        }
                        if(f.getType()==Integer.class || strftype.equals("int")){
                            f.set(newBean, resultSet.getInt(i));
                        }
                        if(f.getType()==Long.class || strftype.equals("long")){
                            f.set(newBean, resultSet.getLong(i));
                        }
                        if(f.getType()==Double.class || strftype.equals("double")){
                            f.set(newBean, resultSet.getDouble(i));
                        }
                        if(f.getType()==Float.class || strftype.equals("float")){
                            f.set(newBean, resultSet.getFloat(i));
                        }
                        if(f.getType()==Short.class || strftype.equals("short")){
                            f.set(newBean, resultSet.getShort(i));
                        }
                        if(f.getType()==String.class){
                            f.set(newBean, resultSet.getString(i));
                        }
                        if(f.getType()== Timestamp.class){
                            f.set(newBean, resultSet.getTimestamp(i));
                        }
                        if(f.getType()==Date.class){
                            f.set(newBean, resultSet.getDate(i));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                result.add(newBean);
            }
        }
        return result;
    }
}
