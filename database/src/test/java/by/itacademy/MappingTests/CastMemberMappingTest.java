package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Film;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CastMemberMappingTest extends BaseTest {
    static final Date DATE = new Date(1451665447567L);

    @Test
    public void testSaveCastMember() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Film f1 = new Film("Friday 13th", LocalDate.now(), "fdfd", "Belarus");
        Film f2 = new Film("Friday 11111th", LocalDate.now(), "fdfgfgfd", "Russia");
        Set<Film> films = new HashSet<>();
        films.add(f1);
        films.add(f2);

        CastMember cm = new CastMember();
        cm.setBirthday(DATE);
        cm.setName("Jason");
        cm.setSurname("Woorhis");
        cm.setGender("MAN");
        cm.setFilms(films);
        session.save(cm);

        CastMember castMember = session.get(CastMember.class, 1);
        Assert.assertEquals(castMember.getName(),"Jason");

        transaction.commit();
        session.close();
    }

}
