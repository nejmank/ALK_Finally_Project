package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;

public class BuyProductTest extends BaseTest{


    @Test
    public void buyNewProduct(){
        ExtentTest test = extentReports.createTest("product buying process", "based on previously entered product");
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookie()
                .setSearchInput("AMD Ryzen 7")
                .searchButtonClick();

    }
}
