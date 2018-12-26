package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDepartureDateAfterOneYear {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testDepartureDateAfterOneYear() {
        flightsSearch.inputFrom("Moscow");
        flightsSearch.inputTo("Delhi");
        flightsSearch.chooseOneWay();
        flightsSearch.inputOutboundDate("15/01/2020");
        flightsSearch.clickSearchButton();
        String expectedError = "The departure date is too far in the future. Select a departure date within the next 360 days. (10721)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
