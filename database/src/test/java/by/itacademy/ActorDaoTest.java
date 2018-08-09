package by.itacademy;

import by.itacademy.dao.ActorDao;
import by.itacademy.entity.Actor;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class ActorDaoTest extends BaseTest {
    static final Date DATE = new Date(1451665447567L);

    @Test
    public void testFindActorsByUnderstudy(){

        Actor cm = new Actor();
        cm.setBirthday(DATE);
        cm.setName("Brad");
        cm.setSurname("Pitt");
        cm.setGender("WOMAN");
        cm.setUnderstudy("Best one");

        Actor cm2 = new Actor();
        cm2.setBirthday(DATE);
        cm2.setName("Angelina");
        cm2.setSurname("Jolie");
        cm2.setGender("WOMAN");
        cm2.setUnderstudy("Best one");

        ActorDao actorDao = new ActorDao();
        actorDao.save(cm);
        actorDao.save(cm2);

        Assert.assertEquals(actorDao.findActorsByUnderstudy("Best one")
                .size(),2);
    }
}
