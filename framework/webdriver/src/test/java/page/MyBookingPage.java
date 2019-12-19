package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.TestDataReader;

public class MyBookingPage extends AbstractPage{
    private final static String NO_BOOKING="//*[@id=\"content_lblError\"]";
    private final static String VIEW="//*[@id=\"content_btnRetrieve\"]";
    private final static String BOOKING_CODE= "//*[@id=\"content_txtCheckoutNumber\"]";

    public static final String BOOKING_NUMBER="testdata.searchmybooking.bookingnumber";
    @FindBy(xpath = BOOKING_CODE)
    private WebElement bookingCode;

    @FindBy(xpath = VIEW)
    private WebElement viewButton;

    @FindBy(xpath = NO_BOOKING)
    private WebElement noBookingTitle;

    public MyBookingPage(WebDriver driver) {
        super(driver);
    }


    public String noBookingNotification(){
        bookingCode.sendKeys(TestDataReader.getTestData(BOOKING_NUMBER));
        viewButton.click();
        logger.info("booking number filled, view button clicked");
        return noBookingTitle.getText().trim();
    }
}