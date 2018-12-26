package by.bsu.zaptot.tests;

import by.bsu.zaptot.driver.DriverProvider;
import by.bsu.zaptot.page.TicketsPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeDepartureCountry {

    private final static String URL = "http://www.at.jal.co.jp/atl/en/?city=WAW";

    private final static String EXPECTED_COUNTRY = "AT_CM";

    private final static String EXPECTED_CITY = "WAW";

    private WebDriver driver;

    private TicketsPage form;

    @BeforeClass
    public void pageSetup() {
        driver = DriverProvider.getDriver();
        driver.get(URL);
        form = PageFactory.initElements(driver, TicketsPage.class);
    }

    @Test
    public void changingCountryToWarszaw() {
        String startCountry = form.getSelectedDepartureCountry();
        String startCity = form.getSelectedDepartureCity();
        Assert.assertEquals(EXPECTED_COUNTRY, startCountry);
        Assert.assertEquals(EXPECTED_CITY, startCity);
    }

    @AfterClass
    public static void tearDown() {
        DriverProvider.closeDriver();
    }
}
