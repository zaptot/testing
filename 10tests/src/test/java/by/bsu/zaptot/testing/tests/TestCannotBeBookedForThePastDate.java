package by.bsu.zaptot.testing.tests;

import by.bsu.zaptot.testing.driver.Driver;
import by.bsu.zaptot.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCannotBeBookedForThePastDate {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.flytap.com/en-pt/");
    }

    @Test
    public void testCannotBeBookedForThePastDate() {
        flightsSearch.inputFrom("(DME) Moscow -  Domodedovo , Russian Federation");
        flightsSearch.inputTo("(GSP) Greenville -  Greenville Spartanburg , United States of America");
        flightsSearch.chooseOneWay();
        flightsSearch.inputOutboundDate("15/10/2018");
        String expectedError = "Please enter a valid date.";
        Assert.assertEquals(expectedError, flightsSearch.error());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
