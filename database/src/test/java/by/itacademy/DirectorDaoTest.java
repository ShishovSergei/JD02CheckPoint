package by.itacademy;

import by.itacademy.dao.DirectorDao;
import by.itacademy.entity.Director;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class DirectorDaoTest extends BaseTest {
    static final Date DATE = new Date(1451665447567L);

    @Test
    public void testFindActorsByUnderstudy(){

        Director cm = new Director();
        cm.setBirthday(DATE);
        cm.setName("Aaron");
        cm.setSurname("Johnson");
        cm.setGender("WOMAN");
        cm.setStudio("Universal");

        Director cm2 = new Director();
        cm2.setBirthday(DATE);
        cm2.setName("Ruby");
        cm2.setSurname("Sky");
        cm2.setGender("WOMAN");
        cm2.setStudio("Universal");

        DirectorDao directorDao = new DirectorDao();
        directorDao.save(cm);
        directorDao.save(cm2);

        Assert.assertEquals(directorDao.findDirectorsByStudio("Universal")
                .size(),2);
    }
}
