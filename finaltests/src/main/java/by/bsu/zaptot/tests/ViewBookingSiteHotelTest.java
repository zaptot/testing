package by.bsu.zaptot.tests;

import by.bsu.zaptot.driver.DriverProvider;
import by.bsu.zaptot.page.HomePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewBookingSiteHotelTest {
    private HomePage flightsSearch = new HomePage();
    private static final String expectedURL="http://www.jal.co.jp/en/inter/option/";

    @BeforeClass
    public static void setup() {
        DriverProvider.getDriver().get("http://www.jal.co.jp/en/");
    }

    @Test
    public void showBookingSite() {
        flightsSearch.clickBookHotel();
        flightsSearch.chooseHotel();
        DriverProvider.getCurrentUrl();
        Assert.assertEquals(DriverProvider.getCurrentUrl(), expectedURL);
    }

    @AfterClass
    public static void tearDown() {
        DriverProvider.closeDriver();
    }
}
