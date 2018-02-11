package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.FilmFormat;
import by.itacademy.entity.FilmGenre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class FilmGenreMappingTest extends BaseTest {
    @Test
    public void testSaveFilmGenre() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        FilmGenre filmGenre = new FilmGenre("Comedy");
        session.save(filmGenre);

        FilmGenre fG = session.get(FilmGenre.class, 1);;
        Assert.assertEquals(fG.getGenre(),"Comedy");

        transaction.commit();
        session.close();
    }
}
