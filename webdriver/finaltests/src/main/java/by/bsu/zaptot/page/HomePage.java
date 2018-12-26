package by.bsu.zaptot.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(id = "js-reservation-tab-status")
    private WebElement flightStatusTab;

    @FindBy(css = "a.btn_Y15.btn-search")
    private WebElement latestFlights;

    @FindBy(id = "js-reservation-tab-hotel-car")
    private WebElement bookHotel;

    @FindBy(css = "span.i.i-booking-com")
    private WebElement bookingHotel;

    @FindBy(className = "is-inter")
    private WebElement routeMap;

    @FindBy(id = "js-reservation-tab-ticket")
    private WebElement tabTicket;

    @FindBy(id = "JS_oneWay")
    private WebElement oneWayTrip;

    @FindBy(id = "JS_flexible")
    private WebElement flexibaleDates;

    @FindBy(id = "JS_submitBtn")
    private WebElement searchOneTrip;

    public void selectFlightTab() {
        Actions actions = new Actions(driver);
        actions.moveToElement(flightStatusTab).click().perform();
    }

    public void selectLatestFlights() {
        Actions actions = new Actions(driver);
        actions.moveToElement(latestFlights).click().perform();
    }

    public void clickBookHotel() {
        Actions actions = new Actions(driver);
        actions.moveToElement(bookHotel).click().perform();
    }

    public void chooseHotel(){
        Actions actions = new Actions(driver);
        actions.moveToElement(bookingHotel).click().perform();
    }

    public void viewRouteMap(){
        Actions actions = new Actions(driver);
        actions.moveToElement(routeMap).click().perform();
    }

    public void selectFlights(){
        Actions actions = new Actions(driver);
        actions.moveToElement(tabTicket).click().perform();
    }

    public void selectOneWay(){
        Actions actions = new Actions(driver);
        actions.moveToElement(oneWayTrip).click().perform();
    }

    public void selectFlexibaleDates(){
        Actions actions = new Actions(driver);
        actions.moveToElement(flexibaleDates).click().perform();
    }

    public void setSearchOneTrip(){
        Actions actions = new Actions(driver);
        actions.moveToElement(searchOneTrip).click().perform();
    }

}
