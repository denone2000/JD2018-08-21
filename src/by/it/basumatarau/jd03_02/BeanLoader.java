package by.it.basumatarau.jd03_02;

import by.it.basumatarau.jd03_02.beans.Place;
import by.it.basumatarau.jd03_02.beans.Role;
import by.it.basumatarau.jd03_02.beans.User;
import by.it.basumatarau.jd03_02.beans.Venue;
import by.it.basumatarau.jd03_02.crud.PlaceCRUD;
import by.it.basumatarau.jd03_02.crud.RoleCRUD;
import by.it.basumatarau.jd03_02.crud.UserCRUD;
import by.it.basumatarau.jd03_02.crud.VenueCRUD;

import java.sql.SQLException;
import java.sql.Timestamp;

public class BeanLoader {
    public static void main(String[] args) throws SQLException {
        DB_init.createEmptyDB();

        RoleCRUD.create(new Role(1,"admin"));
        RoleCRUD.create(new Role(2,"user"));
        RoleCRUD.create(new Role(3,"guest"));

        UserCRUD.create(new User(0, "user1", "asdfj94f", "user1@mail.com", 2));
        UserCRUD.create(new User(0, "user2", "f93j3w4r", "user2@mail.com", 2));
        UserCRUD.create(new User(0, "admin", "d234vHqr", "admin@mail.com", 1));

        PlaceCRUD.create(new Place(0, "some place name", "some place address"));
        PlaceCRUD.create(new Place(0, "another place name", "another place address"));

        VenueCRUD.create(new Venue(99,
                "some venue name",
                "some venue description",
                new Timestamp(999999999999L),
                5.5f,
                2,
                2)
        );
        VenueCRUD.create(new Venue(55,
                "another venue name",
                "another venue description",
                new Timestamp(999999999999L+199999999999L),
                1.5f,
                1,
                1)
        );

    }
}
