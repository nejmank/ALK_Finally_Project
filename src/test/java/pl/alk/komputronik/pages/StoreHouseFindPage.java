package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

public class StoreHouseFindPage {

    @FindBy(css = "h1[class='h1-header']")
    private WebElement findStoreHouseLabel;

    @FindBy(xpath = "//button[@style='float: none']")
    private WebElement locateMeButton;

    @FindBy(xpath = "//input[contains(@class, 'btn')]")
    private WebElement locateMeInput;

    @FindBy(xpath = "//button[@class='btn blue finally-v']")
    private WebElement showLocationButton;

    @FindBy(xpath = "//div[contains(@class, 'points-list')]")
    private WebElement nearbyStorehouseList;

    private WebDriver driver;
    public StoreHouseFindPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getFindStoreHouseLabel(){
        return findStoreHouseLabel;
    }

    public StoreHouseFindPage locateMeButtonClick(){
        locateMeButton.click();
        return this;
    }

    public StoreHouseFindPage setLocateMeInput(String location){
        locateMeInput.sendKeys(location);
        return this;
    }

    public StoreHouseFindPage showLocationButtonClick(){
        showLocationButton.click();
        return this;
    }

    public WebElement storeHouseNearbyList(){
        SeleniumHelper.waitForElementToBeVisible(driver,nearbyStorehouseList);
        return nearbyStorehouseList;
    }

}
