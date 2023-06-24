package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

public class ProductPage {

    @FindBy(xpath = "/html/body/ktr-site/div/ktr-product/ktr-transclude/div[2]/div/div/div[1]/div[2]/div[1]/ktr-product-buy-button/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='shrink-0 px-8 h-12 text-sm font-semibold tracking-wide rounded text-white bg-main-gradient hover:to-blue-smalt']")
    private WebElement noThanksButton;

    @FindBy(xpath = "//button[contains(@class, 'sm:justify-self-end')]")
    private WebElement goToCartButton;

    private WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage addToCartButtonClick(){
        SeleniumHelper.waitForElementToBeVisible(driver, addToCartButton);
        addToCartButton.click();
        return this;
    }
    public ProductPage goToCartButtonClick(){
        SeleniumHelper.waitForElementToBeVisible(driver, goToCartButton);
        goToCartButton.click();
        return this;
    }

    public ProductPage noThanksButtonClick(){
        SeleniumHelper.waitForElementToBeVisible(driver, noThanksButton);
        noThanksButton.click();
        return this;
    }
}
