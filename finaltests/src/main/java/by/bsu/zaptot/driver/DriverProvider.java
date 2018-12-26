package by.bsu.zaptot.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {

    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROMEDRIVER_EXE_PATH =
            "src/main/resources/chromedriver.exe";
    private static WebDriver driver;
    static String currentURL = null;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(WEBDRIVER_CHROMEDRIVER, WEBDRIVER_CHROMEDRIVER_EXE_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static String getCurrentUrl(){
        currentURL = driver.getCurrentUrl();
        return currentURL;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
