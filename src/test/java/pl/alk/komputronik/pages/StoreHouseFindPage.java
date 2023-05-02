package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreHouseFindPage {

    @FindBy(css = "h1[class='h1-header']")
    private WebElement findStoreHouseLabel;

    @FindBy(xpath = "//button[@style='float: none']")
    private WebElement locateMeButton;

    @FindBy(xpath = "//input[contains(@class, 'btn')]")
    private WebElement locateMeInput;

    @FindBy(xpath = "//button[@class='btn blue finally-v']")
    private WebElement showLocationButton;

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

}
