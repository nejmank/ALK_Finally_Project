package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;
import pl.alk.komputronik.pages.SearchFilterPage;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;

public class BuyProductTest extends BaseTest{


    @Test
    public void buyNewProduct() throws IOException {
        ExtentTest test = extentReports.createTest("product buying process", "based on previously entered product");
        HomePage homePage = new HomePage(driver);
        SearchFilterPage searchFilterPage = new SearchFilterPage(driver);

        homePage.acceptCookie()
                .setSearchInput("AMD Ryzen 7")
                .searchButtonClick();

        //Dodanie asercji sprawdzającej czy jesteśmy na stronie z wynikami
        test.log(Status.INFO, "Jesteśmy na stronie z wynikami", SeleniumHelper.getScreenshot(driver));

        searchFilterPage.randomProductClick();




    }
}
