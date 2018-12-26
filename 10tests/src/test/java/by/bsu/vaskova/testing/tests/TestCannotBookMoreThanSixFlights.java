package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class TestCannotBookMoreThanSixFlights {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testCannotBookMoreThanSixFlights() {
        boolean result = true;
       flightsSearch.goToMultiSegment();
       for (int i = 0; i < 3; i++)
           flightsSearch.addFlight();
       try {
           flightsSearch.addFlight();
       } catch (NoSuchElementException e) {
           result = false;
       }
        Assert.assertFalse(result);
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

}
