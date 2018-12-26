package by.bsu.vaskova.testing.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROMEDRIVER_PATH =
            "resources/chromedriver";
    private static WebDriver driver;

    private Driver() { }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(WEBDRIVER_CHROMEDRIVER, WEBDRIVER_CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
