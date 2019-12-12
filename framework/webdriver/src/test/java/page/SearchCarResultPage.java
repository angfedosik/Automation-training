package page;

import driver.DriverSingleton;
import model.SearchCarInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCarResultPage {
    private final int TIMEOUT_SECONDS=10;
    private final static String RESULT_GOOD="/html/body/form/div[5]/div[6]/div[2]/div/ul/li[1]";
    private final static String RESULT_BAD="//*[@id=\"noResults\"]/h3";

    @FindBy(xpath = RESULT_GOOD)
    private WebElement searchedCarInfo;

    @FindBy(xpath = RESULT_BAD)
    private WebElement notFoundTitle;

    private WebDriver driver;
    private SearchCarInfo searchedCars;

    public SearchCarResultPage(WebDriver driver, SearchCarInfo searchedCars){
        this.driver = driver;
        this.searchedCars = searchedCars;
        PageFactory.initElements(driver,this);
    }

    public String noCarNotification(WebDriver driver){
        return notFoundTitle.getText().trim();
    }

    public boolean getSearchCar(WebDriver driver){
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .visibilityOf(searchedCarInfo));
        return errorMessage.isDisplayed();
    }

}