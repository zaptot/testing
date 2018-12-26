package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBookMoreThanFortySeats {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testBookMoreThanFortySeats() {
        flightsSearch.numberOfPassengers("40","5","0");
        flightsSearch.clickSearchButton();
        String expectedError = "You can make bookings for a maximum of 40 passengers at swiss.com. If there are more than 40 passengers travelling, please contact our Service Center. (51003)";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

}
