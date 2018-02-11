package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.Address;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Cinema;
import by.itacademy.entity.Film;
import by.itacademy.enums.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CinemaMappingTest extends BaseTest {
    @Test
    public void testSaveCinema() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Cinema cm = new Cinema(new Address("Minsk","Romanovskaya sloboda"),
                "Belarus","OGON");
        session.save(cm);

        Cinema c = session.get(Cinema.class, 1);
        Assert.assertEquals(c.getName(),"Belarus");

        transaction.commit();
        session.close();
    }
}
