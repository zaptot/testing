package by.bsu.kiselev.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverKiselev {
    private static final String RESOURCE_URL="http://www.jal.co.jp/en/";
    private static final String FLIGHT_STATUS="js-reservation-tab-status";
    private static final String SUCCESS_URL="https://fltinfo.5971.jal.co.jp/rsv/ArrivalAndDepartureSectionInfo_en.do?DPORT=HND&APORT=HND&DATEFLG=";
    private static final String LATEST_FLIGHTS="a.btn_Y15.btn-search";
    String currentURL = null;


    private static final String CHROME_WEBDRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_WEBDRIVER_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

    @Test
    public void isTheSearchByFlightStatusRight(){

        System.setProperty(CHROME_WEBDRIVER_PROPERTY, CHROME_WEBDRIVER_PATH);

        WebDriver driver = new ChromeDriver();

        driver.get(RESOURCE_URL);

        WebElement element = driver.findElement(By.id(FLIGHT_STATUS));
        element.click();

        element=driver.findElement(By.cssSelector(LATEST_FLIGHTS));
        element.click();

        currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        Assert.assertEquals(currentURL,SUCCESS_URL);
        driver.quit();
    }
}
