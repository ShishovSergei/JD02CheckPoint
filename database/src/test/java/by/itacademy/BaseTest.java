package by.itacademy;

import by.itacademy.config.DatabaseConfig;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class BaseTest {
    protected static SessionFactory SESSION_FACTORY;


    /*@BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }*/
}
