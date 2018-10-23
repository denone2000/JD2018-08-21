package by.it.basumatarau.jd03_01;

public class Runner {
    public static void main(String[] args) {

        C_Reset.resetDB();
        C_init.createDB();

        A_AddUser.addUser("new user", "asd34fd", "newuser@mail.com");
        A_AddData.addData("big venue", "presidential elections", 0L, 0.0f, 1, "city hall", "some address");
        A_AddData.addData("small venue", "party", 0L, 0.0f, 1, "pub", "some pub address");
        A_AddData.addData("very small venue", "commute", 0L, 0.0f, 1, "work", "work address");

        B_ShowUsers.showUsers();
        B_AddRoles.addRoles("moderator");
    }
}
