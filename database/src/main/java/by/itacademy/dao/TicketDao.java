package by.itacademy.dao;

import by.itacademy.entity.Ticket;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class TicketDao extends BaseDao<Ticket> {

    public List<Ticket> findTicketsByUserLogin(String login){

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Ticket> result = session
                .createQuery("select e from Ticket e where e.user.login=:login", Ticket.class)
                .setParameter("login",login)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }

    public List<Ticket> findTicketsBySeanceId(int id){

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<Ticket> result = session
                .createQuery("select e from Ticket e where e.seance.id=:id", Ticket.class)
                .setParameter("id",id)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }
}
