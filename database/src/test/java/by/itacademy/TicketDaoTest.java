/*
package by.itacademy;

import by.itacademy.dao.FilmDao;
import by.itacademy.dao.SeanceDao;
import by.itacademy.dao.TicketDao;
import by.itacademy.dao.UserDao;
import by.itacademy.entity.Film;
import by.itacademy.entity.Seance;
import by.itacademy.entity.Ticket;
import by.itacademy.entity.User;
import by.itacademy.enums.UserType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketDaoTest extends BaseTest {

    @Test
    public void testFindTicketsByUserLogin() {

        TicketDao ticketDao = new TicketDao();
        User user1 = new User("login15", "password", "email4525", UserType.USER);
        UserDao userDao = new UserDao();
        userDao.save(user1);

        Ticket ticket = new Ticket(5f, 13, user1);
        Ticket ticket2 = new Ticket(5f, 12, user1);
        Ticket ticket3 = new Ticket(5f, 11, user1);
        ticketDao.save(ticket);
        ticketDao.save(ticket2);
        ticketDao.save(ticket3);

        Assert.assertEquals(ticketDao.findTicketsByUserLogin("login15").size(), 3);
    }

    @Test
    public void testFindTicketsBySeanceId() {

        SeanceDao seanceDao = new SeanceDao();
        Seance seance = new Seance(LocalDate.now(), LocalTime.now());
        seanceDao.save(seance);

        TicketDao ticketDao2 = new TicketDao();

        Ticket ticket = new Ticket(10f, 1, seance);
        Ticket ticket2 = new Ticket(10f, 2, seance);
        Ticket ticket3 = new Ticket(10f, 3, seance);
        ticketDao2.save(ticket);
        ticketDao2.save(ticket2);
        ticketDao2.save(ticket3);

        Assert.assertEquals(ticketDao2.findTicketsBySeanceId(1).size(), 3);
    }


}
*/
