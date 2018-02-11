package by.itacademy.dao;

import by.itacademy.entity.Hall;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class HallDao extends BaseDao<Hall> {

    public List<Hall> findHallsByCinemaId(int id){

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Hall> result = session
                .createQuery("select e from Hall e where e.cinema.id=:id", Hall.class)
                .setParameter("id",id)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
