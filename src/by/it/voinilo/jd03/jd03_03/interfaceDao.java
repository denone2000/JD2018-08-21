package by.it.voinilo.jd03.jd03_03;

import java.util.List;

public interface interfaceDao <TYPE> {
    boolean create (TYPE bean);
    TYPE read(TYPE bean);
    boolean update(TYPE bean);
    boolean delete (TYPE bean);
    List<TYPE> getALL ();
    List<TYPE> getALL (String where);
}
