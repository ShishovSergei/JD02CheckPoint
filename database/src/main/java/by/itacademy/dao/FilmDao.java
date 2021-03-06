package by.itacademy.dao;

import by.itacademy.entity.Film;
import org.hibernate.Session;

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


}
