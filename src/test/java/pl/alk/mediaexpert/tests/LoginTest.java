package pl.alk.mediaexpert.tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pl.alk.mediaexpert.pages.HomePage;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() throws IOException {

        HomePage homePage = new HomePage(driver);

        homePage.myAccountButtonClick();
    }
}
