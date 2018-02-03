package by.itacademy;

import by.itacademy.entity.Actor;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Director;
import by.itacademy.enums.Gender;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Unit test for simple App.
 */
public class FilmDaoTest {
    @org.junit.Test
    public void filmDaoTest(){

        SessionFactory sessionFactory = new Configuration()
                .configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Director d = new Director();

        d.setStudio("studio");
        d.setGender(Gender.MAN);
        d.setName("sds");
        d.setSurname("fgdf");
        session.save(d);
        Actor a = new Actor();
        a.setUnderstudy("yes");
        a.setGender(Gender.MAN);
        a.setName("gdf");
        a.setSurname("fgdfgfgf");
        session.save(a);

        session.createQuery("select c from CastMember c", CastMember.class)
                .list()
                .forEach(System.out::println);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
