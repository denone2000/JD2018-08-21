package by.it.bindyuk.jd03_01;

class Runner {
    public static void main(String[] args) {
        C_Reset.resetBase();
        C_Init.initialization();
        A_AddRoutes.addRoutes();
        A_AddUser.addUser();
        B_AddRoles.addRoles();
        A_AddData.addData();
        B_ShowUsers.showUsers();
    }
}
