package by.itacademy;

import by.itacademy.dao.SeanceDao;
import by.itacademy.entity.Seance;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeanceDaoTest extends BaseTest {

    @Test
    public void testFindSeancesByAgeLimit() {

        SeanceDao seanceDao = new SeanceDao();
        Seance seance = new Seance(LocalDate.now(), LocalTime.now(),"18+");
        Seance seance2 = new Seance(LocalDate.now(), LocalTime.now(),"13+");
        seanceDao.save(seance);
        seanceDao.save(seance2);

        Assert.assertEquals(seanceDao.findSeancesByAgeLimit("18+").size(), 1);
    }

    @Test
    public void testFindSeancesByDate() {

        SeanceDao seanceDao = new SeanceDao();
        Seance seance = new Seance(LocalDate.of(2019,12,23), LocalTime.now(),"16+");
        Seance seance2 = new Seance(LocalDate.now(), LocalTime.now(),"0+");
        seanceDao.save(seance);
        seanceDao.save(seance2);

        Assert.assertEquals(seanceDao.findSeancesByDate(LocalDate.of(2019,12,23))
                .size(), 1);
    }
}
