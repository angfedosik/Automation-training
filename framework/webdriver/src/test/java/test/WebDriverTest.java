package test;

import driver.DriverSingleton;
import model.SearchCarInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.SearchCarHomePage;
import service.SearchCarInfoCreator;
import util.TestListener;

@Listeners(TestListener.class)
public class WebDriverTest {

    private WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetup(){
            driver = DriverSingleton.getDriver();
        }

        @AfterMethod(alwaysRun = true)
        public void browserStop(){
            DriverSingleton.closeDriver();
        }



    @Test
    public void searchCarForRoute(){
        SearchCarInfo searchCar = SearchCarInfoCreator.withSameStartAndEndLocations();
        Boolean isValidationPassed = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .getSearchCar(driver);
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void searchCarForImpossibleRoute(){
        SearchCarInfo searchCar = SearchCarInfoCreator.withDifferentStartAndEndLocations();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithDifferentLocations(searchCar)
                .noCarNotification(driver);
        Assert.assertEquals(errorMessage, "No results found");
    }
}
