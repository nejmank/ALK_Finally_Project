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
    public void invalidLoginTest() throws IOException {
        ExtentTest test = extentReports.createTest("Invalid Login Test", "Invalid login and password");
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookie()
                .loggingButtonClick()
                .enterLogin("TestowyLogin123")
                .enterPassword("Password123")
                .loginButtonClick();

        test.log(Status.PASS, "Login Failed", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(homePage.getLoginErrorMessage().getText(), "Nieprawidłowe logowanie.");

    }
}
