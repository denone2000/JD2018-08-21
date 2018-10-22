package by.it.basumatarau.jd03_03;

import by.it.basumatarau.jd03_03.beans.Place;
import by.it.basumatarau.jd03_03.beans.Role;
import by.it.basumatarau.jd03_03.beans.User;
import by.it.basumatarau.jd03_03.beans.Venue;
import by.it.basumatarau.jd03_03.customDAO.DAO;

import java.sql.SQLException;
import java.sql.Timestamp;

public class RunnerCustomDAO {
    public static void main(String[] args) throws SQLException {
        
        Role someRole = new Role(4, "superuser");
        DAO.getDAO().role.create(someRole);
        System.out.println("Roles: ");
        for (Role role : DAO.getDAO().role.getAll("")) {
            System.out.println(role);
        }
        Role rl = DAO.getDAO().role.read(someRole.getId());
        rl.setRole("supermegauser");
        DAO.getDAO().role.update(rl);
        System.out.println("User roles:");
        for (Role role : DAO.getDAO().role.getAll("")) {
            System.out.println(role);
        }
        DAO.getDAO().role.delete(someRole);
        System.out.println("User roles: ");
        for (Role role : DAO.getDAO().role.getAll("")) {
            System.out.println(role);
        }
        
        
        User someUser = new User(999, "blablabla...", "df3r443", "qwerty@mail.ru", 2);
        DAO.getDAO().user.create(someUser);
        System.out.println("Users: ");
        for (User user : DAO.getDAO().user.getAll("")) {
            System.out.println(user);
        }
        User usr = DAO.getDAO().user.read(someUser.getId());
        usr.setLogin("Blablablayev");
        DAO.getDAO().user.update(usr);
        System.out.println("Users: ");
        for (User user : DAO.getDAO().user.getAll("")) {
            System.out.println(user);
        }
        DAO.getDAO().user.delete(someUser);
        System.out.println("Users: ");
        for (User user : DAO.getDAO().user.getAll("")) {
            System.out.println(user);
        }

        Venue someVenue = new Venue(22,
                "party",
                "not that king of party...",
                new Timestamp(984984984984L),
                10.5f,
                1,
                1);
        DAO.getDAO().venue.create(someVenue);
        System.out.println("Venues: ");
        for (Venue venue : DAO.getDAO().venue.getAll("")) {
            System.out.println(venue);
        }
        Venue vne = DAO.getDAO().venue.read(someVenue.getId());
        vne.setName("Supermegaparty");
        vne.setDescription("THAT kind of party");
        DAO.getDAO().venue.update(vne);
        System.out.println("Venues: ");
        for (Venue venue : DAO.getDAO().venue.getAll("")) {
            System.out.println(venue);
        }
        DAO.getDAO().venue.delete(someVenue);
        System.out.println("Venues: ");
        for (Venue venue : DAO.getDAO().venue.getAll("")) {
            System.out.println(venue);
        }

        Place somePlace = new Place(999, "Hi-end resort", "somewhere in Minsk");
        DAO.getDAO().place.create(somePlace);
        System.out.println("Places: ");
        for (Place place : DAO.getDAO().place.getAll("")) {
            System.out.println(place);
        }
        Place plc = DAO.getDAO().place.read(somePlace.getId());
        plc.setName("crazy drinking party");
        plc.setAddress("somewhere in Mordor");
        DAO.getDAO().place.update(plc);
        System.out.println("Places: ");
        for (Place place : DAO.getDAO().place.getAll("")) {
            System.out.println(place);
        }
        DAO.getDAO().place.delete(somePlace);
        System.out.println("Places: ");
        for (Place place : DAO.getDAO().place.getAll("")) {
            System.out.println(place);
        }
    }
}
