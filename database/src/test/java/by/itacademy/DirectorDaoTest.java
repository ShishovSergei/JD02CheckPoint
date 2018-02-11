package by.itacademy;

import by.itacademy.dao.DirectorDao;
import by.itacademy.entity.Director;
import by.itacademy.enums.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DirectorDaoTest extends BaseTest {

    @Test
    public void testFindActorsByUnderstudy(){

        Director cm = new Director();
        cm.setBirthday(LocalDate.now());
        cm.setName("Aaron");
        cm.setSurname("Johnson");
        cm.setGender(Gender.WOMAN);
        cm.setStudio("Universal");

        Director cm2 = new Director();
        cm2.setBirthday(LocalDate.now());
        cm2.setName("Ruby");
        cm2.setSurname("Sky");
        cm2.setGender(Gender.WOMAN);
        cm2.setStudio("Universal");

        DirectorDao directorDao = new DirectorDao();
        directorDao.save(cm);
        directorDao.save(cm2);

        Assert.assertEquals(directorDao.findDirectorsByStudio("Universal")
                .size(),2);
    }
}
