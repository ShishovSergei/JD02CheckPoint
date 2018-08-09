package by.itacademy.repositories;

import by.itacademy.entity.Seance;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface SeanceRepository extends CrudRepository<Seance, Integer> {

    List<Seance> findSeancesByAgeLimit(String ageLimit);
    List<Seance> findSeancesByDate(Date date);
    List<Seance> findSeancesByDateBetween(Date firstDate, Date secondDate);

}
