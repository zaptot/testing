package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCannotBeBookedForThePastDate {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testCannotBeBookedForThePastDate() {
        flightsSearch.inputFrom("Moscow");
        flightsSearch.inputTo("Delhi");
        flightsSearch.chooseOneWay();
        flightsSearch.inputOutboundDate("15/10/2018");
        flightsSearch.clickSearchButton();
        String expectedError = "The departure date has already passed. Please choose a departure date within the next 339 days. (50700)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
