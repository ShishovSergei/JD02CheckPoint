package by.itacademy;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FilmServiceTest {
    @org.junit.Test
    public void filmServiceTest(){
        Assert.assertEquals(new FilmService().getDefaultFIlm().getCountry(),
                "Беларусь");
    }
}
