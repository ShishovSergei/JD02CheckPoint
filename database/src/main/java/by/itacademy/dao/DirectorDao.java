package by.itacademy.dao;

import by.itacademy.entity.Director;
import org.hibernate.Session;

import java.util.List;

public class DirectorDao extends CastMemberDao<Director> {
    public List<Director> findDirectorsByStudio(String studio) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Director> result = session
                .createQuery("select e from Director e where e.studio=:studio", Director.class)
                .setParameter("studio", studio)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
