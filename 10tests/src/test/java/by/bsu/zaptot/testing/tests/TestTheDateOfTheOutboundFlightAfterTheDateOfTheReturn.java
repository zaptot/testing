package by.bsu.zaptot.testing.tests;

import by.bsu.zaptot.testing.driver.Driver;
import by.bsu.zaptot.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTheDateOfTheOutboundFlightAfterTheDateOfTheReturn {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testTheDateOfTheOutboundFlightAfterTheDateOfTheReturn() {
        flightsSearch.inputFrom("Moscow");
        flightsSearch.inputTo("Delhi");
        flightsSearch.inputOutboundDate("15/05/2019");
        flightsSearch.inputReturnDate("10/05/2019");
        flightsSearch.clickSearchButton();
        String expectedError = "The date of the outbound flight must be before the date of the return flight. Please correct your travel dates. (50400)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

}
