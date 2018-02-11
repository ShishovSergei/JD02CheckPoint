package by.itacademy.dao;

import by.itacademy.entity.Actor;
import org.hibernate.Session;

import java.util.List;

public class ActorDao extends CastMemberDao<Actor> {

    public List<Actor> findActorsByUnderstudy(String understudy) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Actor> result = session
                .createQuery("select e from Actor e where e.understudy=:understudy", Actor.class)
                .setParameter("understudy", understudy)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
