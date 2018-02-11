package by.itacademy;

import by.itacademy.dao.FilmDao;
import by.itacademy.dao.UserDao;
import by.itacademy.entity.Film;
import by.itacademy.entity.User;
import by.itacademy.enums.UserType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UserDaoTest extends BaseTest{

    @Test
    public void testFindUsersByType(){

        UserDao userDao = new UserDao();
        User user1 = new User("login","password","email", UserType.USER);
        User user2 = new User("login2","password","email2", UserType.USER);
        User user3 = new User("login23","password23","email23", UserType.ADMIN);
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);

        Assert.assertEquals(userDao.findUsersByType(UserType.ADMIN).size(),1);
    }

    @Test
    public void testFindUserByEmail(){

        UserDao userDao = new UserDao();
        User user1 = new User("login34","password","email245", UserType.USER);
        User user2 = new User("login254","password","2452", UserType.USER);
        userDao.save(user1);
        userDao.save(user2);

        User found = userDao.findUserByEmail("2452");
        Assert.assertEquals(found.getPassword(), "password");
    }
}
