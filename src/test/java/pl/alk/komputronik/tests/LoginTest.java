package pl.alk.komputronik.tests;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLoginTest(String username, String password) throws IOException {
        ExtentTest test = extentReports.createTest("Invalid Login Test", "Invalid login and password");
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookie()
                .loggingButtonClick()
                .enterLogin(username)
                .enterPassword(password)
                .loginButtonClick();

        test.log(Status.PASS, "Nie udało się zalogować!", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(homePage.getLoginErrorMessage().getText(), "Nieprawidłowe logowanie.");

    }
}
