package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestOneInfantForOneAdult {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testOneInfantForOneAdult() {
        flightsSearch.numberOfPassengers("2","0","5");
        flightsSearch.clickSearchButton();
        String expectedError = "The number of infants may not exceed the number of adults. (51002)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
