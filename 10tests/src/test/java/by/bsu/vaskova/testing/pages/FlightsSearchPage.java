package by.bsu.vaskova.testing.pages;

import by.bsu.vaskova.testing.driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsSearchPage {

    WebDriver driver;

    @FindBy(id = "FlightOrigin")
    private WebElement fromField;

    @FindBy(id = "FlightDestination")
    private WebElement toField;

    @FindBy(id="FlightOutboundDate")
    private WebElement outboundFlight;

    @FindBy(id = "FlightInboundDate")
    private WebElement returnFlight;

    @FindBy(className = "evo-button js-evo-bookingbar--submit")
    private WebElement searchButton;

    @FindBy(className = "notification-message")
    private WebElement textError;

    @FindBy(css = "#h1")
    private WebElement title;

    @FindBy(id = "site-header")
    private WebElement header;

    @FindBy(className = "booking_bar--column booking_bar--passengers js-evo-bookingbar--passengers is-active")
    private WebElement passengers;

    @FindBy(id = "FlightAdults")
    private WebElement adults;

    @FindBy(id = "FlightChildren")
    private WebElement children;

    @FindBy(id = "FlightInfant")
    private WebElement infants;

    @FindBy(className = "evo-passenger_select--popup--button js-evo-passenger_select--close")
    private WebElement close_pass;

    @FindBy(className = "evo-flight_toggle--single")
    private WebElement one_way;

    @FindBy(className = "evo-flight_toggle--return")
    private WebElement two_way;

    @FindBy(id = "aamenu-trigger-3")
    private WebElement book_in_header;

    @FindBy(id = "tabs_1_2")
    private WebElement multi_segment_journey;

    @FindBy(className = "btn btn-green ico btn-right ico-buttonicon-add js-ajax-update-click js-multirow-add")
    private WebElement add_flight_button;

    @FindBy(className = "js-site_search--trigger meta_nav--site_search--trigger")
    private WebElement button_with_loupe;

    @FindBy(id = "search")
    private WebElement search;

    public FlightsSearchPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void inputFrom(String from_city) {
        fromField.sendKeys(from_city);
    }

    public void inputTo(String to_city) {
        toField.sendKeys(to_city);
    }

    public void inputOutboundDate(String outbound_date) {
        returnFlight.clear();
        returnFlight.sendKeys(outbound_date);
    }

    public void inputReturnDate(String return_date) {
        returnFlight.clear();
        returnFlight.sendKeys(return_date);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String error() {
        return textError.getText();
    }

    public String realTitle() {
        return title.getText();
    }

    public void clickHeader() {
        header.click();
    }

    public void numberOfPassengers(String num_of_adults, String num_of_children, String num_of_infants) {
        passengers.click();
        adults.sendKeys(num_of_adults);
        children.sendKeys(num_of_children);
        infants.sendKeys(num_of_infants);
        close_pass.click();
    }

    public void chooseOneWay() {
        one_way.click();
    }

    public void goToMultiSegment() {
        book_in_header.click();
        multi_segment_journey.click();
    }

    public void addFlight() {
        add_flight_button.click();
    }

    public void siteSearch(String search_str) {
        button_with_loupe.click();
        search.sendKeys(search_str);
        search.sendKeys(Keys.ENTER);
    }
}
