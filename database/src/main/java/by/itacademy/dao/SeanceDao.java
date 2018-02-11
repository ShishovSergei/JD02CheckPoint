package by.itacademy.dao;

import by.itacademy.entity.Seance;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class SeanceDao extends BaseDao<Seance> {

    public List<Seance> findSeancesByAgeLimit(String ageLimit) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Seance> result = session
                .createQuery("select e from Seance e where e.ageLimit=:ageLimit", Seance.class)
                .setParameter("ageLimit", ageLimit)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public List<Seance> findSeancesByDate(LocalDate date) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Seance> result = session
                .createQuery("select e from Seance e where e.date=:date", Seance.class)
                .setParameter("date", date)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
