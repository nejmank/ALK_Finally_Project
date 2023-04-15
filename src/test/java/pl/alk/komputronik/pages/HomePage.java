package pl.alk.komputronik.pages;

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

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//p[contains(text(),'Nieprawidłowe logowanie.')]")
    private WebElement errorLoginMessage;


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

}
