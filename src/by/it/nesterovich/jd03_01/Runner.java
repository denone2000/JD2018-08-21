package by.it.nesterovich.jd03_01;

public class Runner {

    public static void main(String[] args) {

        C_Init.cInit();

        A_AddUser.addUser("user2", "puser2", "user2@gmail.com");
        A_AddData.addData(87645678, 8.6, "2", "2", "3");
        A_AddData.addData(37645667, 9.0, "2", "3", "2");
        A_AddData.addData(67645375, 8.0, "2", "1", "1");

        B_AddRoles.addRoles("guest");
        B_ShowUsers.showUsers();

        C_Reset.cReset();
    }
}
