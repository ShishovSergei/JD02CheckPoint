package by.itacademy;

import by.itacademy.entity.Actor;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Film;
import by.itacademy.enums.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ActorMappingTest extends BaseTest {

    @Test
    public void testSaveActor() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Film f1 = new Film("Friday 13th", LocalDate.now(), "fdfd", "Belarus");
        Film f2 = new Film("Friday 11111th", LocalDate.now(), "fdfgfgfd", "Russia");
        Set<Film> films = new HashSet<>();
        films.add(f1);
        films.add(f2);

        Actor actor = new Actor("Will");
        actor.setBirthday(LocalDate.now());
        actor.setName("Jason");
        actor.setSurname("Woorhis");
        actor.setGender(Gender.MAN);
        actor.setFilms(films);
        session.save(actor);

        Actor ac = session.get(Actor.class, 1);
        Assert.assertEquals(ac.getUnderstudy(),"Will");

        transaction.commit();
        session.close();
    }
}
