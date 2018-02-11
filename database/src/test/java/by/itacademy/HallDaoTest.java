package by.itacademy;

import by.itacademy.dao.CinemaDao;
import by.itacademy.dao.HallDao;
import by.itacademy.dao.SeanceDao;
import by.itacademy.entity.Address;
import by.itacademy.entity.Cinema;
import by.itacademy.entity.Hall;
import by.itacademy.entity.Seance;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class HallDaoTest extends BaseTest {

    @Test
    public void testFindHallsByCinemaId() {

        CinemaDao cinemaDao = new CinemaDao();
        Cinema cm = new Cinema(new Address("Minsk","Surganova"),
                "Oktyabr","OGON!");
        cinemaDao.save(cm);

        HallDao hallDao = new HallDao();
        Hall hall1 = new Hall(200, cm);
        Hall hall2 = new Hall(300, cm);
        Hall hall3 = new Hall(100, cm);
        hallDao.save(hall1);
        hallDao.save(hall2);
        hallDao.save(hall3);

        Assert.assertEquals(hallDao.findHallsByCinemaId(1).size(),3);
    }
}
