package by.bsu.kiselev.pageobject.test;

import by.bsu.kiselev.pageobject.page.hotelBook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ViewBookingSiteHotelTest {

    public static WebDriver driver;
    public static hotelBook hotelbook;
    private static final String expectedURL="https://www.booking.com/?aid=384270";
    String currentURL = null;


    @BeforeClass
    public static void setur() {
         System.setProperty("webdriver.chrome.driver", ".//resources//chromedriver.exe");
        driver = new ChromeDriver();
        hotelbook = new hotelBook(driver);
        driver.manage().window().maximize();
        driver.get("http://www.jal.co.jp/en/");
    }

    @Test
    public void showBookingSite() {
        hotelbook.clickBookHotel();
        hotelbook.chooseHotel();
        hotelbook.chooseBooking();
        currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL, expectedURL);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
