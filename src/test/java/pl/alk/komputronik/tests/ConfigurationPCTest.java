package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.alk.komputronik.pages.*;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.io.IOException;

public class ConfigurationPCTest extends BaseTest{


    @Test
    public void configurationPCSetupTest() throws IOException{
        ExtentTest test = extentReports.createTest("Configure PC Test", "Random products");
        HomePage homePage = new HomePage(driver);
        ConfigurationPCPage configurationPCPage = new ConfigurationPCPage(driver);
        CPUPage cpuPage = new CPUPage(driver);
        GPUPage gpuPage = new GPUPage(driver);
        MotherboardPage motherboardPage = new MotherboardPage(driver);
        DRAMPage dramPage = new DRAMPage(driver);
        HDDPage hddPage = new HDDPage(driver);
        PowerSupplyPage powerSupplyPage = new PowerSupplyPage(driver);
        CasePage casePage = new CasePage(driver);
        SummaryConfigurationPCPage summaryConfigurationPCPage = new SummaryConfigurationPCPage(driver);


        homePage.acceptCookie()
                .configurationPCButtonClick();

        Assert.assertTrue(configurationPCPage.getConfigurationPCLabel().isDisplayed());
        test.log(Status.INFO, "Jesteśmy na stronie do konfiguracji PC", SeleniumHelper.getScreenshot(driver));

        configurationPCPage.chooseCPUButtonClick();
        cpuPage.randomCPUProductClick()
                .chooseGPUButtonClick();
        gpuPage.randomGPUProductClick()
                .chooseMotherboardButtonClick();
        motherboardPage.randomMotherboardProductClick()
                .chooseDRAMButtonClick();
        dramPage.randomDRAMProductClick()
                .chooseHDDButtonClick();
        hddPage.randomHDDProductClick()
                .choosePowerSupplyButtonClick();
        powerSupplyPage.randomPowerSupplyProductClick()
                .chooseCaseButtonClick();
        casePage.randomCaseProductClick()
                .goToSummaryButtonClick();


        Assert.assertTrue(summaryConfigurationPCPage.getSummaryPCLabel().isDisplayed());
        test.log(Status.PASS, "Udało się przejść proces konfiguracji PC", SeleniumHelper.getScreenshot(driver));


    }
}
