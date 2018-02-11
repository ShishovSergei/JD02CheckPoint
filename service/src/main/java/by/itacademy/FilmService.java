package by.itacademy;

import by.itacademy.entity.Film;

/**
 * @author Сергей
 * @version 1.0
 */
public class FilmService {
    public Film getDefaultFIlm() {
        return new FilmDaoOld().getDefaultFilm();
    }
}
