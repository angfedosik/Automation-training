package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInfoPage extends AbstractPage{

    private static final String CUSTOMER_INFORMATION = "//*[@id=\"checkoutForm\"]/div[1]/section[1]/h5";

    @FindBy(xpath = CUSTOMER_INFORMATION)
    private WebElement customerInformationTitle;

    public CustomerInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getCustomerInformationTitleText() {
        return customerInformationTitle.getText().trim();
    }
}