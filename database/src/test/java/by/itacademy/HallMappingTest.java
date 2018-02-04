package by.itacademy;

import by.itacademy.entity.FilmFormat;
import by.itacademy.entity.Hall;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class HallMappingTest extends BaseTest {
    @Test
    public void testSaveHall() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hall hall = new Hall(350);
        session.save(hall);

        Hall h = session.get(Hall.class, 1);
        Assert.assertEquals(h.getCapacity(),350);

        transaction.commit();
        session.close();
    }
}
