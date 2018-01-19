package by.itacademy;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FilmDaoTest {
    @org.junit.Test
    public void filmDaoTest(){
        Assert.assertEquals(new FilmDao().getDefaultFilm(),
                "Доктор Стрейнджлав, или Как я перестал бояться и полюбил бомбу");
    }
}
