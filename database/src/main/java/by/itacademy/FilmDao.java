package by.itacademy;

import by.itacademy.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

/**
 * @author Сергей
 */
public class FilmDao {
    public Film getDefaultFilm() {
        SessionFactory sessionFactory = new Configuration()
                .configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Film film = new Film("Бессонные ночи", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        transaction.commit();
        sessionFactory.close();
        return film;
    }
}
