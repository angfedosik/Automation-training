package page;

import model.SearchCarInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCarResultPage extends AbstractPage{
    private static final String CARS_FOUND="/html/body/form/div[5]/div[6]/div[2]/div/ul/li[1]";
    private static final String CARS_NOT_FOUND="//*[@id=\"noResults\"]/h3";
    private static final String DOUBLE_CHECK_QUERY= "//*[@id=\"divError\"]";
    private static final String TOO_CLOSE_DATE="//*[@id=\"content_carSearchCtrl_lblError\"]";
    private static final String BOOK="//*[@id=\"queryResult\"]/div[2]/div/ul/li[1]/div/div[2]/a";

    @FindBy(xpath = CARS_FOUND)
    private WebElement searchedCarInfo;

    @FindBy(xpath = CARS_NOT_FOUND)
    private WebElement notFoundTitle;

    @FindBy(xpath = DOUBLE_CHECK_QUERY)
    private WebElement doubleCheckQueryTitle;

    @FindBy(xpath = TOO_CLOSE_DATE)
    private WebElement tooCloseDateTitle;

    @FindBy(xpath = BOOK)
    private WebElement bookButton;

    private SearchCarInfo searchedCars;

    public SearchCarResultPage(WebDriver driver, SearchCarInfo searchedCars){
        super(driver);
        this.searchedCars = searchedCars;
        PageFactory.initElements(driver,this);
    }

    public String noCarNotification(WebDriver driver){
        logger.info("no car notification gotten: " + tooCloseDateTitle.getText());
        return notFoundTitle.getText().trim();
    }

    public boolean getSearchCar(WebDriver driver){
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .visibilityOf(searchedCarInfo));
        logger.info("error message gotten: " + errorMessage.getText());
        return errorMessage.isDisplayed();
    }

    public String notValidQueryNotification(WebDriver driver){
        logger.info("not valid notification gotten: " + doubleCheckQueryTitle.getText());
        return doubleCheckQueryTitle.getText().trim();
    }

    public String tooCloseDateNotification(WebDriver driver){
        logger.info("too close date notification gotten: " + tooCloseDateTitle.getText());
        return tooCloseDateTitle.getText().trim();
    }

    public BookingInfoPage bookCar(WebDriver driver){
        bookButton.click();
        logger.info("book button clicked");
        return new BookingInfoPage(driver);
    }
}