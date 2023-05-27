package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.CartPage;
import pl.alk.komputronik.pages.HomePage;
import pl.alk.komputronik.pages.ProductPage;
import pl.alk.komputronik.pages.SearchFilterPage;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;

public class BuyProductTest extends BaseTest{


    @Test
    public void addRandomProductToCart() throws IOException {
        ExtentTest test = extentReports.createTest("product buying process", "based on previously entered product");
        HomePage homePage = new HomePage(driver);
        SearchFilterPage searchFilterPage = new SearchFilterPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.acceptCookie()
                .setSearchInput("AMD Ryzen 7");


        test.log(Status.INFO, "Jesteśmy na stronie z wynikami", SeleniumHelper.getScreenshot(driver));

        searchFilterPage.randomProductClick();
        productPage.addToCartButtonClick()
                .goToCartButtonClick();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.komputronik.pl/cart");
        test.log(Status.PASS, "Dodaliśmy produkt do koszyka", SeleniumHelper.getScreenshot(driver));
        Assert.assertTrue(cartPage.goNextButtonIsDisplayed().isDisplayed());

    }
}
