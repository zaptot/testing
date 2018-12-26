package by.bsu.zaptot.tests;

import by.bsu.zaptot.driver.DriverProvider;
import by.bsu.zaptot.page.HomePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TheSearchByFlightStatusRight {
    private HomePage flightsSearch = new HomePage();
    private static final String SuccesURL="https://fltinfo.5971.jal.co.jp/rsv/ArrivalAndDepartureSectionInfo_en.do?DPORT=HND&APORT=HND&DATEFLG=";


    @BeforeClass
    public static void setup() {
        DriverProvider.getDriver().get("http://www.jal.co.jp/en/");
    }

    @Test
    public void testSearchByFlightStatus() {
        flightsSearch.selectFlightTab();
        flightsSearch.selectLatestFlights();
        DriverProvider.getCurrentUrl();
        Assert.assertEquals(DriverProvider.getCurrentUrl(),SuccesURL);
    }

    @AfterClass
    public static void tearDown() {
        DriverProvider.closeDriver();
    }

}
