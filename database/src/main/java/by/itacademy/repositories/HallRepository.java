package by.itacademy.repositories;

import by.itacademy.entity.Hall;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HallRepository extends CrudRepository<Hall, Integer> {
    List<Hall> findHallsByCinemaId(int id);
}
