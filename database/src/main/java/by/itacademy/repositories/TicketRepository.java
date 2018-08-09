package by.itacademy.repositories;

import by.itacademy.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    List<Ticket> findTicketsByUserLogin(String login);
    List<Ticket> findTicketsBySeanceId(int id);
}
