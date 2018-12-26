package by.bsu.zaptot.testing.tests;

import by.bsu.zaptot.testing.driver.Driver;
import by.bsu.zaptot.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEnterNonFlyingCountry {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testEnterNonFlyingCountry() {
        flightsSearch.inputFrom("London");
        flightsSearch.inputTo("Belarus");
        flightsSearch.clickSearchButton();
        String expectedError = "Your chosen airport Belarus has not been found or cannot be booked online. For further information please contact our Service Center. (50501)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
