package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArrivalAndDepartureAreTheSame {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testArrivalAndDepartureAreTheSame() {
        flightsSearch.inputFrom("Moscow");
        flightsSearch.inputTo("Moscow");
        String expectedError = "The departure and arrival airports cannot be the same. Please correct your entry. (51120)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
