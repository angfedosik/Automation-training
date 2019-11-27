import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCarHomePage {

    private final static String HOMEPAGE_URL="https://www.ibookacar.com/";
    private final static String LOCATION_PICKUP="//*[@id=\"ajxPickupLocation\"]";
    private final static String DATE_PICKUP="//*[@id=\"content_carSearchCtrl_txtPickupDate\"]";
    private final static String TIME_SELECTOR_PICKUP="//*[@id=\"content_carSearchCtrl_ddlPickupHour\"]";
    private final static String TIME_PICKUP="//*[@id=\"content_carSearchCtrl_ddlPickupHour\"]/option[12]";

    private final static String LOCATION_DROPOFF="//*[@id=\"ajxDropoffLocation\"]";
    private final static String DATE_DROPOFF="//*[@id=\"content_carSearchCtrl_txtDropOffDate\"]";
    private final static String TIME_SELECTOR_DROPOFF="//*[@id=\"content_carSearchCtrl_ddlDropOffHour\"]";
    private final static String TIME_DROPOFF="//*[@id=\"content_carSearchCtrl_ddlDropOffHour\"]/option[11]";

    private final static String SEARCH_BUTTON="//*[@id=\"content_carSearchCtrl_btnSearch\"]";
    private final static String DROPOFF_LOCATION_CHECKBOX="//*[@id=\"chkSameDropOffLocation\"]";

    private WebDriver driver;

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

    public SearchCarHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SearchCarHomePage openHomePage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void baseFillIn(SearchCar searchCar){
        locationPickUp.sendKeys(searchCar.getPickUpLocation());
        datePickUp.sendKeys(searchCar.getPickUpDate());
        timeSelectorPickUp.click();
        timePickUp.click();
        dateDropOff.sendKeys(searchCar.getDropOffDate());
        timeSelectorDropOff.click();
        timeDropOff.click();
        searchButton.click();
    }

    public SearchCarResult searchCarWithSameLocations(SearchCar searchCar){
        baseFillIn(searchCar);
        return new SearchCarResult(driver, searchCar);

    }

    public SearchCarResult searchCarWithDifferentLocations(SearchCar searchCar){
        dropOffLocationCheckbox.click();
        locationDropOff.sendKeys(searchCar.getDropOffLocation());
        baseFillIn(searchCar);
        return new SearchCarResult(driver, searchCar);

    }
}
