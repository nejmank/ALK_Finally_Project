package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

public class RegistrationPage {

    private WebDriver driver;
    @FindBy(xpath = "//strong[contains(text(),'Rejestracja')]")
    private WebElement registerNameLabel;
    @FindBy(xpath = "//input[@name='customer_login']")
    private WebElement registerInputEmail;

    @FindBy(xpath = "//input[@name='customer_password']")
    private WebElement registerInputPassword;

    @FindBy(xpath = "//input[@name='customer_postal_code']")
    private WebElement registerInputPostalCode;

    @FindBy(xpath = "//input[@id='customer_company_rules_terms']")
    private WebElement companyRulesTermsCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Załóż konto')]")
    private WebElement registerAccountButton;

    @FindBy(xpath = "//div[contains(text(),'Potwierdź że nie jesteś robotem')]")
    private WebElement registerErrorMessage;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegisterNameLabel(){
        SeleniumHelper.waitForElementToBeVisible(driver, registerNameLabel);
        return registerNameLabel;
    }

    public RegistrationPage setRegisterInputEmail(String email){
        registerInputEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage setRegisterInputPassword(String password){
        registerInputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage setRegisterInputPostalCode(String postalCode){
        registerInputPostalCode.sendKeys(postalCode);
        return this;
    }

    public RegistrationPage CompanyRulesTermsCheckboxClick(){
        SeleniumHelper.scrollDown(driver, companyRulesTermsCheckbox);
        companyRulesTermsCheckbox.click();
        return this;
    }

    public RegistrationPage registerAccountButtonClick(){
        SeleniumHelper.scrollDown(driver, registerAccountButton);
        registerAccountButton.click();
        return this;
    }

    public WebElement getRegisterErrorMessage(){
        return registerErrorMessage;
    }
}
