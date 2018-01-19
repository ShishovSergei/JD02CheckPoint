package by.itacademy;

/**
 * @author Сергей
 * @version 1.0
 */
public class FilmService {
    public String getDefaultFIlm() {
        return new FilmDao().getDefaultFilm();
    }
}
