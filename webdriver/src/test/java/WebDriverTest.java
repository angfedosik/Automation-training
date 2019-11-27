import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverTest {

    private String datePickup="28/11/2019";
    private String dateDropOff="28/12/2019";
    private WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetup(){
            driver = new ChromeDriver();
        }

        @AfterMethod(alwaysRun = true)
        public void browserTearDown(){
            driver.quit();
            driver = null;
        }



    @Test
    public void searchCarForRoute(){
        SearchCar searchCar = new SearchCar("Minsk, Belarus - Minsk Intl 1","11/30/2019","10:00am", "12/10/2019","10:00am");
        Boolean isValidationPassed = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .getSearchCar(driver);
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void searchCarForImpossibleRoute(){
        SearchCar searchCar = new SearchCar("Minsk, Belarus - Minsk Intl 1","11/30/2019","10:00am", "Washington, United States - Ronald Reagan National", "12/10/2019","10:00am");
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithDifferentLocations(searchCar)
                .noCarNotification(driver);
        Assert.assertEquals(errorMessage, "No results found");
    }
}
