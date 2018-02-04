package by.itacademy;

import by.itacademy.entity.*;
import by.itacademy.enums.Gender;
import by.itacademy.enums.UserType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Сергей
 */
public class FilmDao {
    public static void main(String[] args) {
        {
            SessionFactory sessionFactory = new Configuration()
                    .configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Director d = new Director();
            ;
            d.setStudio("studio");
            d.setGender(Gender.MAN);
            d.setName("sds");
            d.setSurname("fgdf");
            session.save(d);

            Actor a = new Actor();
            a.setUnderstudy("yes");
            a.setGender(Gender.MAN);
            a.setName("gdf");
            a.setSurname("fgdfgfgf");
            session.save(a);

            Set<CastMember> cm = new HashSet<>();
            cm.add(a);
            cm.add(d);

            Film f1 = new Film("Friday 13th", LocalDate.now(), "fdfd", "Belarus");
            f1.setCastMembers(cm);
            session.save(f1);

            session.createQuery("select c from Film c", Film.class)
                    .list()
                    .forEach(System.out::println);

            /*d.setStudio("studio");
            d.setGender(Gender.WOMAN);
            d.setName("sds");
            d.setSurname("fgdf");
            session.save(d);*/
            /*Actor a = new Actor();
            a.setUnderstudy("sffdfgfgd");
            a.setGender(Gender.MAN);
            a.setName("564cv6");
            a.setSurname("hyrdcvsr");
            session.save(a);
            User u = new User();
            u.setType(UserType.USER);
            u.setLogin("45dfd45");
            u.setPassword("rgfdfwgr");
            session.save(u);

            session.createQuery("select c from CastMember c", CastMember.class)
                    .list()
                    .forEach(System.out::println);*/


            transaction.commit();
            session.close();
            sessionFactory.close();

        }
    }
}
