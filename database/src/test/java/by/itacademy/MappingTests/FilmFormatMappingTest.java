package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.Film;
import by.itacademy.entity.FilmFormat;
import by.itacademy.entity.Seance;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class FilmFormatMappingTest extends BaseTest {
    @Test
    public void testSaveFilmFormat() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        FilmFormat filmFormat = new FilmFormat("2D");
        session.save(filmFormat);

        FilmFormat fF = session.get(FilmFormat.class, 1);
        Assert.assertEquals(fF.getFormat(),"2D");

        transaction.commit();
        session.close();
    }

}
