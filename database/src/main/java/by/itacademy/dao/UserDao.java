package by.itacademy.dao;

import by.itacademy.entity.User;
import by.itacademy.enums.UserType;
import org.hibernate.Session;

import java.util.List;

public class UserDao extends BaseDao<User> {

    public List<User> findUsersByType(UserType type) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<User> result = session
                .createQuery("select e from User e where e.type=:type", User.class)
                .setParameter("type", type)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public User findUserByEmail(String email) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        User result = session
                .createQuery("select e from User e where e.email=:email", User.class)
                .setParameter("email", email)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
