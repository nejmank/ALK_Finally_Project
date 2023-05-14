package pl.alk.komputronik.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {

    public static WebDriver getDriver() throws IOException{
        String name = PropertiesLoader.loadProperty("browser.name");
        ChromeOptions options = new ChromeOptions();

        if (name.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            return new ChromeDriver(options);
        }
    }
}
