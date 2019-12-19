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

    @Test
    public void searchWithEmptyField(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withEmptyLocation();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .notValidQueryNotification(driver);
        Assert.assertEquals(errorMessage, "Please double-check your query and try again.");
    }

    @Test
    public void searchWithNotExistLocation(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withNotExistLocation();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .notValidQueryNotification(driver);
        Assert.assertEquals(errorMessage, "Please double-check your query and try again.");
    }

    @Test
    public void searchWithSameDateAndTime(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withSameDateAndTime();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .noCarNotification(driver);
        Assert.assertEquals(errorMessage, "No results found");
    }

    @Test
    public void searchWithLongBookingPeriod(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withLongBookingPeriod();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .noCarNotification(driver);
        Assert.assertEquals(errorMessage, "No results found");
    }

    @Test
    public void searchWithPastDate(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withPastDate();
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .tooCloseDateNotification(driver);
        Assert.assertEquals(errorMessage, "Rental pick-up date is too close. Call us to complete your booking.");
    }

    @Test
    public void searchBookingWithNotExistNumber(){
        String errorMessage = new SearchCarHomePage(driver)
                .openHomePage()
                .searchMyBooking()
                .noBookingNotification();
        Assert.assertEquals(errorMessage, "There is no booking for that code. Double check and try again.");
    }

    @Test
    public void getBookingInfoPage(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withPastDate();
        String bookingInfoTitle = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .bookCar(driver)
                .getYourReservationTitleText();
        Assert.assertEquals(bookingInfoTitle, "Your car reservation");
    }

    @Test
    public void getCustomerInfoPage(){
        SearchCarInfo searchCar=SearchCarInfoCreator.withPastDate();
        String customerInfoTitle = new SearchCarHomePage(driver)
                .openHomePage()
                .searchCarWithSameLocations(searchCar)
                .bookCar(driver)
                .getCustomerInformationPage()
                .getCustomerInformationTitleText();
        Assert.assertEquals(customerInfoTitle, "Customer information");
    }
}
