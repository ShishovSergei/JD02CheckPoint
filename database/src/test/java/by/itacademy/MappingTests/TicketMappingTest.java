package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.FilmFormat;
import by.itacademy.entity.Hall;
import by.itacademy.entity.Seance;
import by.itacademy.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketMappingTest extends BaseTest {
    @Test
    public void testSaveTicket() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hall hall = new Hall(240);
        session.save(hall);
        FilmFormat filmFormat = new FilmFormat("2D");
        session.save(filmFormat);
        Seance seance = new Seance(LocalDate.of(2017,5,30),
                LocalTime.now(),hall,filmFormat);
        session.save(seance);

        Ticket ticket = new Ticket(450f, 35, seance);
        session.save(ticket);

        Ticket t = session.get(Ticket.class, 1);
        Assert.assertEquals(t.getPlace(),35);
        Assert.assertEquals(t.getPrice(),450f);

        transaction.commit();
        session.close();
    }
}
