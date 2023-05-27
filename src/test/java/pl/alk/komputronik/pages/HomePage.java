package pl.alk.komputronik.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

public class HomePage {

    @FindBy(xpath = "//span[contains(text(),'Zaloguj')]")
    private WebElement loggingButton;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Zaloguj się')]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//p[contains(text(),'Nieprawidłowe logowanie.')]")
    private WebElement errorLoginMessage;

    @FindBy(xpath = "//button[contains(text(),'Załóż konto')]")
    private WebElement registerButton;

    @FindBy(css = ".items-center.header-link-hidden")
    private WebElement storehouseFindButton;

    @FindBy(xpath = "//input[@id='wp-autocomplete']")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/ktr-site/div/div[2]/div/div/div[8]/ktr-new-slider-with-scroll-transclude/div/div[2]/section/div/ol/li[3]/div/a/p")
    private WebElement configuratorPCButton;

    private WebDriver driver;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage loggingButtonClick(){
        loggingButton.click();
        return this;
    }

    public HomePage enterLogin(String login){
        SeleniumHelper.waitForElementToBeVisible(driver, loginInput);
        loginInput.sendKeys(login);
        return this;
    }

    public HomePage enterPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage loginButtonClick(){
        loginButton.click();
        return this;
    }

    public HomePage acceptCookie(){
        acceptCookieButton.click();
        return this;
    }
    public WebElement getLoginErrorMessage(){
        SeleniumHelper.waitForElementToBeVisible(driver, errorLoginMessage);
        return errorLoginMessage;
    }

    public HomePage registerButtonClick(){
        registerButton.click();
        return this;
    }

    public HomePage storeHouseFindButtonClick(){
        SeleniumHelper.waitForElementToBeVisible(driver,storehouseFindButton);
        storehouseFindButton.click();
        return this;
    }

    public HomePage setSearchInput(String productName){
        SeleniumHelper.waitForElementToBeVisible(driver , searchInput);
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage configurationPCButtonClick(){
        SeleniumHelper.scrollIntoView(driver , configuratorPCButton);
        configuratorPCButton.click();
        return this;
    }

}
