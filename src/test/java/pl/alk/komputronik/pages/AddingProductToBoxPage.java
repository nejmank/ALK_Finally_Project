package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

public class AddingProductToBoxPage {

    @FindBy(xpath = "//h2[contains(@class, 'pr-12')]")
    private WebElement addingProductToBoxLabel;

    @FindBy(xpath = "//span[contains(@class, 'text-sm')]")
    private WebElement productNameLabel;

    @FindBy(xpath = "//button[@ng-click='$ctrl.savePolicyOnClose(true)']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'border')]")
    private WebElement continueShoppingButton;

    private WebDriver driver;
    public AddingProductToBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAddingProductToCartLabel(){
        return addingProductToBoxLabel;
    }

    public WebElement getProductNameLabel(){
        return productNameLabel;
    }

    public AddingProductToBoxPage goToCartButtonClick(){
        SeleniumHelper.scrollIntoView(driver, goToCartButton);
        goToCartButton.click();
        return this;
    }

    public AddingProductToBoxPage continueShoppingButtonClick(){
        SeleniumHelper.scrollIntoView(driver, continueShoppingButton);
        continueShoppingButton.click();
        return this;
    }

}
