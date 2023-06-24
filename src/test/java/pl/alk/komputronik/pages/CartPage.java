package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.util.List;

public class CartPage {

    @FindBy(xpath = "//li[contains(@ng-class, '}')]")
    private List<WebElement> cartProductList;

    @FindBy(xpath = "//a[contains(@class, 'btn2')]")
    private WebElement goNextButton;

    @FindBy(xpath = "//button[@ng-if='$ctrl.isOrder']")
    private WebElement buyWithoutLoginButton;

    private WebDriver driver;
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }

    public List<WebElement> getCartProductList(){
        return cartProductList;
    }

    public WebElement goNextButtonIsDisplayed(){
        SeleniumHelper.waitForElementToBeVisible(driver, goNextButton);
        return goNextButton;
    }

    public CartPage buyWithoutLoginButtonClick(){
        buyWithoutLoginButton.click();
        return this;
    }

}
