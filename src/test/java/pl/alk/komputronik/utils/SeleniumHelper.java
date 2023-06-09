package pl.alk.komputronik.utils;


import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {

    public static Media getScreenshot(WebDriver driver) throws IOException{
        String path = takeScreenshot(driver);

        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    private static String takeScreenshot(WebDriver driver) throws IOException{
        int randomNumber = (int) (Math.random()* 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "/home/student/AquaProjects/ALK_Finally_Project/src/test/resources/screenshots/screenshot"+ randomNumber +".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

    public static void waitForElementToExist(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollDownIfElement1IsOverlappingElement2(WebDriver driver, WebElement element1, WebElement element2){
        if (element1.isDisplayed() && element2.isDisplayed()){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
        }
    }

    public static void waitForNumberOfElementsToBeMoreThan(WebDriver driver, WebElement element, Integer number){
        new WebDriverWait(driver, Duration.ofSeconds(number)).
                until(ExpectedConditions.numberOfElementsToBeMoreThan((By) element, number));
    }



    public static void scrollUp(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
    }



}
