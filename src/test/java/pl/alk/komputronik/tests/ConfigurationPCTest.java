package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.HomePage;

import java.io.IOException;

public class ConfigurationPCTest extends BaseTest{


    @Test
    public void ConfigurationPCSetupTest() throws IOException{
        ExtentTest test = extentReports.createTest("Configure PC Test", "Random products");
        HomePage homePage = new HomePage(driver);

        homePage.acceptCookie()
                .configurationPCButtonClick();

    }
}
