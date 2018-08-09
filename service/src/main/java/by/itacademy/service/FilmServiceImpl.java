package by.itacademy.service;

import by.itacademy.entity.Film;
import by.itacademy.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * @author Сергей
 * @version 1.0
 */
@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    private FilmRepository filmRepository;

    @Override
    public List<Film> getFilmsForToday() {
        return filmRepository.getFilmsByRealiseDate(date);
    }
}
