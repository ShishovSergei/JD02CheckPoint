package by.itacademy;

import by.itacademy.dao.CastMemberDao;
import by.itacademy.entity.Actor;
import by.itacademy.entity.CastMember;
import by.itacademy.entity.Director;
import by.itacademy.enums.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CastMemberDaoTest extends BaseTest {

    @Test
    public void testCastMembersByGender(){

        CastMember cm = new Actor();
        cm.setBirthday(LocalDate.now());
        cm.setName("Jason");
        cm.setSurname("Woorhis");
        cm.setGender(Gender.MAN);

        CastMember cm2 = new Director();
        cm2.setBirthday(LocalDate.now());
        cm2.setName("Anna");
        cm2.setSurname("Faris");
        cm2.setGender(Gender.WOMAN);

        CastMemberDao<CastMember> castMemberDao = new CastMemberDao<>();
        castMemberDao.save(cm);
        castMemberDao.save(cm2);

        Assert.assertEquals(castMemberDao.findCastMembersByGender(Gender.MAN).size(),1);
    }

    @Test
    public void testFindCastMembersByFullName(){

        CastMember cm = new Actor();
        cm.setBirthday(LocalDate.now());
        cm.setName("Brad");
        cm.setSurname("Pitt");
        cm.setGender(Gender.WOMAN);

        CastMember cm2 = new Director();
        cm2.setBirthday(LocalDate.now());
        cm2.setName("Angelina");
        cm2.setSurname("Jolie");
        cm2.setGender(Gender.WOMAN);

        CastMemberDao<CastMember> castMemberDao = new CastMemberDao<>();
        castMemberDao.save(cm);
        castMemberDao.save(cm2);

        Assert.assertEquals(castMemberDao.findCastMembersByFullName("Angelina","Jolie")
                .size(),1);
        Assert.assertEquals(castMemberDao.findCastMembersByFullName("Brad","Pitt")
                .size(),1);
    }


}
