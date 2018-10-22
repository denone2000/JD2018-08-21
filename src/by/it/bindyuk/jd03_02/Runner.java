package by.it.bindyuk.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        TaskC.reset();
        TaskC.initializing();
        TaskC.addRole("admin");
        TaskC.addRole("user");
        TaskC.addUser("DURALEY", "123qwe", "sobaka@tut.by", "MP",
                438293,"0001 0002 0003 0004", 352, 2);
        TaskC.addUser("admin","admin","admin@gmail.com",null,
                0,null,0,1);
        TaskC.addRoute("Minsk");
        TaskC.addRoute("Grodno");
        TaskC.addRoute("Vitsiebsk");
        TaskC.addRoute("Mogilev");
        TaskC.addRoute("Brest");
        TaskC.addRoute("Gomel");
        TaskC.addTicket("plain",1,2,21,10,2030,2);
    }
}
