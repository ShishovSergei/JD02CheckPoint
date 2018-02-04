package by.itacademy;

import by.itacademy.entity.Actor;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Director;
import by.itacademy.entity.Film;
import by.itacademy.enums.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class FilmMappingTest extends BaseTest {
    @Test
    public void testSaveFilm() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Film f1 = new Film("Friday 13th", LocalDate.now(), "fdfd", "Belarus");
        session.save(f1);
        Film f = session.get(Film.class, 1);
        Assert.assertEquals(f1.getCountry(),"Belarus");

        transaction.commit();
        session.close();
    }

}
