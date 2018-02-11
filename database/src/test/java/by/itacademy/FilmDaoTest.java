package by.itacademy;

import by.itacademy.dao.FilmDao;
import by.itacademy.entity.Film;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class FilmDaoTest extends BaseTest{

    @Test
    public void testFindById() {

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Бессонные ночи", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        filmDao.save(film);

        Film found = filmDao.findById(1);
        Assert.assertEquals(found.getCountry(), "Беларусь");
    }

    @Test
    public void testUpdate(){

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Бессонные ночи", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        filmDao.save(film);

        Film found = filmDao.findById(1);
        found.setCountry("Japan");
        filmDao.update(found);
        Assert.assertEquals(found.getCountry(), "Japan");
        found.setCountry("Беларусь");
        filmDao.update(found);

    }

    @Test
    public void testDelete(){

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Бессонные ночи", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        filmDao.save(film);

        filmDao.delete(film);
    }

    @Test
    public void testFindAll(){

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Бессонные ночи", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        Film film2 = new Film("Бессонные ночи 2", LocalDate.now(),
                "great", "Japan");
        filmDao.save(film);
        filmDao.save(film2);

        filmDao.findAll();
    }

    @Test
    public void testFindFilmsByTitle(){

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Жизнь прекрасна", LocalDate.now(),
                "Отличный фильм", "Беларусь");
        Film film2 = new Film("Жизнь прекрасна", LocalDate.now(),
                "great", "Japan");
        filmDao.save(film);
        filmDao.save(film2);

        Assert.assertEquals(filmDao.findFilmsByTitle("Жизнь прекрасна").size(),2);
    }

    @Test
    public void testFindFilmsByCountry(){

        FilmDao filmDao = new FilmDao();
        Film film = new Film("Эти странные люди", LocalDate.now(),
                "Отличный фильм", "USA");
        Film film2 = new Film("Тесты как смысл жизни", LocalDate.now(),
                "great", "USA");
        filmDao.save(film);
        filmDao.save(film2);

        Assert.assertEquals(filmDao.findFilmsByCountry("USA").size(),2);
    }
}
