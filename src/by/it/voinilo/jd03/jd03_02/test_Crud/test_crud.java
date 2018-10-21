package by.it.voinilo.jd03.jd03_02.test_Crud;

import by.it.voinilo.jd03.jd03_02.CRUD.RoleCrub;
import by.it.voinilo.jd03.jd03_02.beans.RoleParam;

import java.sql.SQLException;

public class test_crud {
    public static void main(String[] args) throws SQLException {
        RoleCrub roleCrub = new RoleCrub();
        RoleParam role = new RoleParam(0, "ADMINISTRATOR");
        roleCrub.create(role);

    }
}
