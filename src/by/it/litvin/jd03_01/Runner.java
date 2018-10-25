package by.it.litvin.jd03_01;

public class Runner {

    public static void main(String[] args) {
       C_Init.init();
//      C_Reset.reset();
      A_AddUser.addUser("Tadaroku","123","tadaroku@mail.ru",2);
        A_AddData.addData("1","2","3","4",5,"6","7",2);
        B_AddRoles.addRoles("admin");
        B_ShowUsers.showUsers();



    }


}
