package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_03.beans.Role;
import by.it.bindyuk.jd03_03.beans.Route;
import by.it.bindyuk.jd03_03.beans.Ticket;
import by.it.bindyuk.jd03_03.beans.User;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class TestDao {

    //==================================================================================================================
    //создаем экземпляр Dao и всех entity из БД
    private Dao dao = Dao.getDao();
    private User user = new User(0, "test",
            "test", "test", "test",
            1234, "test", 123, 2);
    private Role role = new Role(0, "test");
    private Route route = new Route(0, "New York");
    private Ticket ticket = new Ticket(0, "TEST",
            1, 2, new Timestamp(66666666),2);

    //==================================================================================================================
    //Тест операций CRUD для USER
    @Test
    public void TestUserCRUD() throws SQLException {
        assertTrue(dao.user.create(user));
        assertNotNull(dao.user.read(user.getId()));
        user.setLogin("testtest");
        assertTrue(dao.user.update(user));
        assertTrue(dao.user.delete(user));
    }

    //==================================================================================================================
    //Тест операций CRUD для ROLE
    @Test
    public void TestRoleCRUD() throws SQLException {
        assertTrue(dao.role.create(role));
        assertNotNull(dao.role.read(role.getId()));
        role.setRole("TESTTEST");
        assertTrue(dao.role.update(role));
        assertTrue(dao.role.delete(role));
    }

    //==================================================================================================================
    //Тест операций CRUD для ROUTE
    @Test
    public void TestRouteCRUD() throws SQLException {
        assertTrue(dao.route.create(route));
        assertNotNull(dao.route.read(route.getId()));
        route.setCity("TESTTEST");
        assertTrue(dao.route.update(route));
        assertTrue(dao.route.delete(route));
    }

    //==================================================================================================================
    //Тест операций CRUD для TICKET
    @Test
    public void TestTicketCRUD() throws SQLException {
        assertTrue(dao.ticket.create(ticket));
        assertNotNull(dao.ticket.read(ticket.getId()));
        ticket.setTransport("PARAPLAN");
        assertTrue(dao.ticket.update(ticket));
        assertTrue(dao.ticket.delete(ticket));
    }
}