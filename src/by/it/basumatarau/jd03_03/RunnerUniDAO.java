package by.it.basumatarau.jd03_03;

import by.it.basumatarau.jd03_03.beans.Venue;
import by.it.basumatarau.jd03_03.genericsDAO.UniDAO;

import java.sql.SQLException;
import java.sql.Timestamp;

public class RunnerUniDAO {
    public static void main(String[] args) throws SQLException {

        @SuppressWarnings("unchecked")
        UniDAO<Venue> venueDAO = UniDAO.getDAO(Venue.class, "Venues");

        for (Venue venue : venueDAO.getAll("")) {
            System.out.println(venue);
        }
        Venue someVenue = new Venue(22,
                "party",
                "not that king of party...",
                new Timestamp(984984984984L),
                10.5f,
                1,
                1);
        if(venueDAO.create(someVenue))
            System.out.println("UniDAOinst.create() - OK");
        someVenue.setDescription("THAT kind of party...");
        someVenue.setFee(1000.1f);

        if(venueDAO.update(someVenue))
            System.out.println("UniDAOinst.create() - OK");

        int startingFrom = 2;
        for (Venue venue : venueDAO.getAll("")) {
            if(--startingFrom<0){
                venueDAO.delete(venue);
            }
        }

    }
}
