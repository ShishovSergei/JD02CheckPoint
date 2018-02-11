package by.itacademy.MappingTests;

import by.itacademy.BaseTest;
import by.itacademy.entity.FilmGenre;
import by.itacademy.entity.User;
import by.itacademy.enums.UserType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class UserMappingTest extends BaseTest {
    @Test
    public void testSaveUser() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User("user228", "1234", "322forlive@gmail.com", UserType.USER);
        session.save(user);

        User u = session.get(User.class, 1);
        Assert.assertEquals(u.getEmail(), "322forlive@gmail.com");

        transaction.commit();
        session.close();
    }
}
