package by.it.litvin.jd03_02;


import java.sql.SQLException;

public class Runner {

    public static void main(String[] args)throws SQLException {
//      C_Reset.reset();
//      A_AddUser.addUser("Tadaroku","123","tadaroku@mail.ru",2);
//        A_AddData.addData("Minsk","Young",16,"schoolgirl","friendship",2);
//        B_AddRoles.addRoles("admin");
//        B_ShowUsers.showUsers();
        TaskC.addForm("sasha","zankovich","minsk","young",18,"student","relationship",0);
        TaskC.addRole("admin");
        TaskC.addUser("Edward","ed","edward@mail.ru",2);




    }


}
