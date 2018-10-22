package by.it.artemliashkov.jd03_01;

public class Runner {

    public static void main(String[] args) {

        TaskC_Init.cInit();
        TaskA_AddUser.addUser("natasha", "gintovta");
        TaskA_AddData.addData("natasha", "gintovta",111,"222",2);
        TaskB_AddRoles.addRoles("guest");
        TaskB_ShowUsers.showUsers();

        TaskC_Reset.cReset();
    }}
