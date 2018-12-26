package by.bsu.zaptot.testing.tests;

import by.bsu.zaptot.testing.driver.Driver;
import by.bsu.zaptot.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCorrectSearch {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.flytap.com/en-pt/");
    }

    @Test
    public void testArrivalAndDepartureAreTheSame() {
        flightsSearch.siteSearch("check-in");
        String expectedTitle = "Search results for \"check-in\"";
        //assertEquals(expectedTitle, flightsSearch.realTitle());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }
}
