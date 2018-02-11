package by.itacademy.dao;

import by.itacademy.entity.CastMember;
import by.itacademy.enums.Gender;
import org.hibernate.Session;

import java.util.List;

public class CastMemberDao<T extends CastMember> extends BaseDao<CastMember> {

    public List<CastMember> findCastMembersByGender(Gender gender) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<CastMember> result = session
                .createQuery("select e from CastMember e where e.gender=:gender", CastMember.class)
                .setParameter("gender", gender)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public List<CastMember> findCastMembersByFullName(String name, String surname) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<CastMember> result = session
                .createQuery("select e from CastMember e where e.name=:name and e.surname=:surname", CastMember.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
