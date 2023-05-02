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

public class StoreHouseFindTest extends BaseTest {

    @Test
    public void StoreHouseFindUsingLatitudeAndLongitude() throws IOException {
        ExtentTest test = extentReports.createTest("Find your nearest store", "Use Latitude and Longitude");
        HomePage homePage = new HomePage(driver);
        StoreHouseFindPage storeHouseFindPage = new StoreHouseFindPage(driver);



        homePage.acceptCookie()
                .storeHouseFindButtonClick();

        test.log(Status.INFO, "Jesteśmy na stronie do wyszukiwania sklepu", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(storeHouseFindPage.getFindStoreHouseLabel().getText(), "Znajdź sklep");

        storeHouseFindPage.setLocateMeInput("")
                .showLocationButtonClick();

    }

}
