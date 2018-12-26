package by.bsu.vaskova.testing.tests;

import by.bsu.vaskova.testing.driver.Driver;
import by.bsu.vaskova.testing.pages.FlightsSearchPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCorrectWorkWithCorrectFillingOfAllFields {
    private FlightsSearchPage flightsSearch = new FlightsSearchPage();

    @BeforeClass
    public static void setur() {
        Driver.getDriver().get("https://www.swiss.com/pl/en");
    }

    @Test
    public void testCorrectWorkWithCorrectFillingOfAllFields() {
        flightsSearch.inputFrom("Moscow");
        flightsSearch.inputTo("Delhi");
        flightsSearch.clickSearchButton();
        String expectedTitle = "Moscow To Delhi";
        assertEquals(expectedTitle, flightsSearch.realTitle());
    }

    @AfterClass
    public static void tearDown() {
        Driver.closeDriver();
    }

}
