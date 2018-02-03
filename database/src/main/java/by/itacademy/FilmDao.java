package by.itacademy;

import by.itacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Сергей
 */
public class FilmDao {
    public static void main(String[] args) {
        {
            SessionFactory sessionFactory = new Configuration()
                    .configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Director d = new Director();
            d.setStudio("studio");


            transaction.commit();
            session.close();
            sessionFactory.close();

        }
    }
}
