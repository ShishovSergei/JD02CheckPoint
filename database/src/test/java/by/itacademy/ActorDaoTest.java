package by.itacademy;

import by.itacademy.dao.ActorDao;
import by.itacademy.entity.Actor;
import by.itacademy.enums.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ActorDaoTest extends BaseTest {

    @Test
    public void testFindActorsByUnderstudy(){

        Actor cm = new Actor();
        cm.setBirthday(LocalDate.now());
        cm.setName("Brad");
        cm.setSurname("Pitt");
        cm.setGender("WOMAN");
        cm.setUnderstudy("Best one");

        Actor cm2 = new Actor();
        cm2.setBirthday(LocalDate.now());
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
