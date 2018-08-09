package by.itacademy.repositories;

import by.itacademy.entity.Film;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findFilmsByTitle(String title);
    List<Film> findFilmsByCountry(String country);
    List<Film> getFilmsByRealiseDate(Date realiseDate);
    List<Film> findFilmByCountryIsNotNullAndRealiseDateIsBetween(Date firstDate, Date secondDate);

}
