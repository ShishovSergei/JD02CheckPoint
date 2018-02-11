package by.itacademy.dao;

import by.itacademy.entity.Film;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class FilmDao extends BaseDao<Film> {

    public List<Film> findFilmsByTitle(String title) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Film> result = session
                .createQuery("select e from Film e where e.title=:title", Film.class)
                .setParameter("title", title)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public List<Film> findFilmsByCountry(String country) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Film> result = session
                .createQuery("select e from Film e where e.country=:country", Film.class)
                .setParameter("country", country)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public List<Film> findFilmsByTitleRealiseDateCountry(String title, LocalDate realiseDate, String country, int limit, int offset) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Film> result = session
                .createQuery("select e from Film e where e.title=:title and "
                        + "e.realiseDate=:realiseDate and e.country=:country", Film.class)
                .setParameter("title", title)
                .setParameter("realiseDate", realiseDate)
                .setParameter("country", country)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }


}
