package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.Address;
import by.itacademy.entity.Cinema;
import by.itacademy.entity.Director;
import by.itacademy.enums.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class DirectorMappingTest extends BaseTest {

    @Test
    public void testSaveDirector() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Director d = new Director();
        d.setStudio("studioo");
        d.setGender("MAN");
        d.setName("sds");
        d.setSurname("fgdf");
        session.save(d);

        Director director = session.get(Director.class, 1);
        Assert.assertEquals(d.getStudio(), "studioo");

        transaction.commit();
        session.close();
    }

}
