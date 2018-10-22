package by.it.galushka.jd03_03;

public interface InterfaceDAO<TYPE> {

    boolean create(TYPE bean);
    TYPE read(long id);
    boolean update(TYPE bean);
    boolean delete(TYPE bean);
}
