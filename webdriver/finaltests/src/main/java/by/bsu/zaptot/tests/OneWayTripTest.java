package by.bsu.zaptot.tests;

import by.bsu.zaptot.driver.DriverProvider;
import by.bsu.zaptot.page.HomePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OneWayTripTest {
    private HomePage flightsSearch = new HomePage();
    private static final String SuccesURL="https://www.5971.jal.co.jp/eng/LFSSearchDispatch.do";

    @BeforeClass
    public static void setup() {
        DriverProvider.getDriver().get("http://www.jal.co.jp/en/");
    }

    @Test
    public void testViewRouteMap() {
        flightsSearch.selectFlights();
        flightsSearch.selectOneWay();
        flightsSearch.selectFlexibaleDates();
        flightsSearch.setSearchOneTrip();
        DriverProvider.getCurrentUrl();
    }

    @AfterClass
    public static void tearDown() {
        DriverProvider.closeDriver();
    }
}
