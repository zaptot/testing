package by.bsu.zaptot.tests;

import by.bsu.zaptot.driver.DriverProvider;
import by.bsu.zaptot.page.TicketsPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrivalCityChangeTest {

    private final static String URL = "http://www.ru.jal.co.jp/rul/en/?city=MOW";
    private final static String ARRIVAL_COUNTRY = "AU_CM";
    private final static String EXPECTED_ARRIVAL_CITY = "SYD";

    private WebDriver driver;

    private TicketsPage form;

    @BeforeClass
    public void pageSetup() {
        driver = DriverProvider.getDriver();
        driver.get(URL);
        form = PageFactory.initElements(driver, TicketsPage.class);
    }

    @Test
    public void shouldChangeCityByArrivalCountry() {
        form.toggleForm();
        form.selectArrivalCountry(ARRIVAL_COUNTRY);
        String cityName = form.getArrivalLocation();
        Assert.assertEquals(EXPECTED_ARRIVAL_CITY, cityName);
    }

    @Test(dependsOnMethods = {"shouldChangeCityByArrivalCountry"})
    public void getReturnedDateFieldsByOneWay() {
        form.selectOneWay();
        boolean isReturningDateFieldsEnabled = form.isReturningDateFieldsEnabled();
        Assert.assertFalse(isReturningDateFieldsEnabled);
    }

    @Test(dependsOnMethods = {"shouldChangeCityByArrivalCountry"})
    public void getErrorMessageBy0Adults() throws InterruptedException {
        form.selectAdultsAmount("0");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);
        form.toggleForm();
        form.toggleForm();
    }

    @Test(dependsOnMethods = {"shouldChangeCityByArrivalCountry"})
    public void getErrorMessageBy6Children() throws InterruptedException {
        form.selectAdultsAmount("2");
        form.selectChildrenAmount("6");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);
        form.toggleForm();
        form.toggleForm();
    }

    @Test(dependsOnMethods = {"shouldChangeCityByArrivalCountry"})
    public void getErrorMessageBy4Infants() throws InterruptedException {
        form.selectAdultsAmount("2");
        form.selectChildrenAmount("0");
        form.selectInfantsAmount("4");
        form.submit();
        Thread.sleep(2000);
        boolean gotError = form.isErrorMessageDisplayed();
        Assert.assertTrue(gotError);
    }

    @AfterClass
    public static void tearDown() {
        DriverProvider.closeDriver();
    }
}
