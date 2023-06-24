package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;
import pl.alk.komputronik.pages.RegistrationPage;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;

public class RegisterTest extends BaseTest{

    @Test
    public void RegisterWithoutReCaptchaClicked() throws IOException {
        ExtentTest test = extentReports.createTest("Invalid Registration Test", "Captcha is not Checked");
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        homePage.acceptCookie()
                .loggingButtonClick()
                .registerButtonClick();

        test.log(Status.INFO, "We are on registration page", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(registrationPage.getRegisterNameLabel().getText(), "REJESTRACJA");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.komputronik.pl/register");

        registrationPage.setRegisterInputEmail("testMail@gmail.com")
                .setRegisterInputPassword("Password123")
                .setRegisterInputPostalCode("00-000")
                .CompanyRulesTermsCheckboxClick()
                .registerAccountButtonClick();

        test.log(Status.PASS, "Registration Failed", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(registrationPage.getRegisterErrorMessage().getText(), "Potwierdź że nie jesteś robotem");

    }

}
