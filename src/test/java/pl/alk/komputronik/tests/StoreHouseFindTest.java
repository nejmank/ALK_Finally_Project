package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;
import pl.alk.komputronik.pages.StoreHouseFindPage;
import pl.alk.komputronik.utils.JavaUtils;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;
import java.util.Arrays;

public class StoreHouseFindTest extends BaseTest {

    @Test
    public void storeHouseFindUsingLatitudeAndLongitude() throws IOException {
        ExtentTest test = extentReports.createTest("Find your nearest store", "Use Latitude and Longitude");
        HomePage homePage = new HomePage(driver);
        StoreHouseFindPage storeHouseFindPage = new StoreHouseFindPage(driver);
        String myIP = JavaUtils.getCurrentIP();
        String location = Arrays.toString(JavaUtils.getLatLongFromIP(myIP));

        homePage.acceptCookie()
                .storeHouseFindButtonClick();


        Assert.assertEquals(storeHouseFindPage.getFindStoreHouseLabel().getText(), "Znajdź sklep");
        test.log(Status.INFO, "We are on the shop search page", SeleniumHelper.getScreenshot(driver));

        storeHouseFindPage.setLocateMeInput(location)
                .showLocationButtonClick();

        Assert.assertTrue(storeHouseFindPage.storeHouseNearbyList().isDisplayed());
        test.log(Status.PASS, "The list with available stores has been displayed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void storeHouseFindUsingCityName() throws IOException{
        ExtentTest test = extentReports.createTest("Find your nearest store", "Use City Name");
        HomePage homePage = new HomePage(driver);
        StoreHouseFindPage storeHouseFindPage = new StoreHouseFindPage(driver);

        homePage.acceptCookie()
                .storeHouseFindButtonClick();

        Assert.assertEquals(storeHouseFindPage.getFindStoreHouseLabel().getText(), "Znajdź sklep");
        test.log(Status.INFO, "We are on the shop search page", SeleniumHelper.getScreenshot(driver));

        storeHouseFindPage.setLocateMeInput("Warszawa")
                .showLocationButtonClick();

        Assert.assertTrue(storeHouseFindPage.storeHouseNearbyList().isDisplayed());
        test.log(Status.PASS, "The list with available stores has been displayed", SeleniumHelper.getScreenshot(driver));
    }

}
