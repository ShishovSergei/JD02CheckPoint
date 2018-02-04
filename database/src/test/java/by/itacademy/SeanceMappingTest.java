package by.itacademy;

import by.itacademy.entity.Film;
import by.itacademy.entity.FilmFormat;
import by.itacademy.entity.Hall;
import by.itacademy.entity.Seance;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeanceMappingTest extends BaseTest {
    @Test
    public void testSaveSeance() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hall hall = new Hall(240);
        session.save(hall);
        FilmFormat filmFormat = new FilmFormat("2D");
        session.save(filmFormat);
        Seance seance = new Seance(LocalDate.of(2017,5,30),
                LocalTime.now(),hall,filmFormat);
        session.save(seance);

        Seance s = session.get(Seance.class, 1);
        Assert.assertEquals(s.getDate(),LocalDate.of(2017,5,30));

        transaction.commit();
        session.close();
    }
}
