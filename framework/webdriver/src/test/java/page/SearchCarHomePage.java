package page;

import model.SearchCarInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCarHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL="https://www.ibookacar.com/";
    private static final String LOCATION_PICKUP="//*[@id=\"ajxPickupLocation\"]";
    private static final String DATE_PICKUP="//*[@id=\"content_carSearchCtrl_txtPickupDate\"]";
    private static final String TIME_SELECTOR_PICKUP="//*[@id=\"content_carSearchCtrl_ddlPickupHour\"]";
    private static final String TIME_PICKUP="//*[@id=\"content_carSearchCtrl_ddlPickupHour\"]/option[12]";

    private static final String LOCATION_DROPOFF="//*[@id=\"ajxDropoffLocation\"]";
    private static final String DATE_DROPOFF="//*[@id=\"content_carSearchCtrl_txtDropOffDate\"]";
    private static final String TIME_SELECTOR_DROPOFF="//*[@id=\"content_carSearchCtrl_ddlDropOffHour\"]";
    private static final String TIME_DROPOFF="//*[@id=\"content_carSearchCtrl_ddlDropOffHour\"]/option[11]";

    private static final String SEARCH_BUTTON="//*[@id=\"content_carSearchCtrl_btnSearch\"]";
    private static final String DROPOFF_LOCATION_CHECKBOX="//*[@id=\"chkSameDropOffLocation\"]";

    private static final String MY_BOOKING_BUTTON="//*[@id=\"form1\"]/div[4]/nav/section/ul/li[4]/a";


    @FindBy(xpath = LOCATION_PICKUP)
    private WebElement locationPickUp;

    @FindBy(xpath = DATE_PICKUP)
    private WebElement datePickUp;

    @FindBy(xpath = TIME_SELECTOR_PICKUP)
    private WebElement timeSelectorPickUp;

    @FindBy(xpath = TIME_PICKUP)
    private WebElement timePickUp;

    @FindBy(xpath = LOCATION_DROPOFF)
    private WebElement locationDropOff;

    @FindBy(xpath = DATE_DROPOFF)
    private WebElement dateDropOff;

    @FindBy(xpath = TIME_SELECTOR_DROPOFF)
    private WebElement timeSelectorDropOff;

    @FindBy(xpath = TIME_DROPOFF)
    private WebElement timeDropOff;

    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = DROPOFF_LOCATION_CHECKBOX)
    private WebElement dropOffLocationCheckbox;

    @FindBy(xpath = MY_BOOKING_BUTTON)
    private WebElement myBookingButton;

    public SearchCarHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public SearchCarHomePage openHomePage(){
        driver.get(HOMEPAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public void baseFillIn(SearchCarInfo searchCarInfo){
        locationPickUp.sendKeys(searchCarInfo.getPickUpLocation());
        datePickUp.clear();
        datePickUp.sendKeys(searchCarInfo.getPickUpDate());
        timeSelectorPickUp.click();
        timePickUp.click();
        dateDropOff.clear();
        dateDropOff.sendKeys(searchCarInfo.getDropOffDate());
        timeSelectorDropOff.click();
        timeDropOff.click();
        searchButton.click();
        logger.info("Base information filled");
    }

    public SearchCarResultPage searchCarWithSameLocations(SearchCarInfo searchCarInfo){
        baseFillIn(searchCarInfo);
        return new SearchCarResultPage(driver, searchCarInfo);

    }

    public SearchCarResultPage searchCarWithDifferentLocations(SearchCarInfo searchCarInfo){
        dropOffLocationCheckbox.click();
        locationDropOff.sendKeys(searchCarInfo.getDropOffLocation());
        logger.info("Drop off location filled");
        baseFillIn(searchCarInfo);
        return new SearchCarResultPage(driver, searchCarInfo);

    }

    public MyBookingPage searchMyBooking(){
        myBookingButton.click();
        logger.info("My booking button clicked");
        return new MyBookingPage(driver);
    }

}
