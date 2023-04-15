package pl.alk.komputronik.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.alk.komputronik.utils.DriverFactory;
import pl.alk.komputronik.utils.PropertiesLoader;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extentReports;


    @BeforeSuite
    public void beforeSuite(){
        sparkReporter = new ExtentSparkReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void afterSuite(){
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() throws IOException{
        String pageName = PropertiesLoader.loadProperty("page.name");

        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(pageName);
    }

    @AfterMethod
    public void tearDown() {driver.quit();}
}
