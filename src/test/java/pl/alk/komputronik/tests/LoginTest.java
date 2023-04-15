package pl.alk.komputronik.tests;


import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() throws IOException {

        HomePage homePage = new HomePage(driver);

        homePage.myAccountButtonClick();
    }
}
