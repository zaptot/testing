package by.bsu.kiselev.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hotelBook {

    public hotelBook(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(id = "i reservation-tab-hotel-car")
    private WebElement bookHotel;

    @FindBy(className = "i i-booking-com")
    private WebElement bookingHotel;

    @FindBy(xpath = "a.iconOther")
    private WebElement siteBooking;


    public void clickBookHotel() {
        bookHotel.click();
    }

    public void chooseHotel(){
        bookingHotel.click();
    }

    public void chooseBooking(){
        siteBooking.click();
    }
}
