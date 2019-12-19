package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingInfoPage extends AbstractPage{
    private static final String YOUR_RESERVATION="//*[@id=\"product\"]/div/div/h3";
    private static final String NEXT="//*[@id=\"content_btnContinue\"]";

    @FindBy(xpath = NEXT)
    private WebElement nextButton;

    @FindBy(xpath = YOUR_RESERVATION)
    private WebElement yourReservationTitle;

    public BookingInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getYourReservationTitleText(){
        return yourReservationTitle.getText().trim();
    }

    public CustomerInfoPage getCustomerInformationPage() {
        return new CustomerInfoPage(driver);
    }
}