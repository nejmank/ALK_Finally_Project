package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OderCheckoutPage {

    @FindBy(xpath = "//div[@class='checkout-type-wrap']")
    private List<WebElement> checkoutTypeButtons;


    private WebDriver driver;

    public OderCheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    public List<WebElement> getCheckoutTypeButtons(){
        return checkoutTypeButtons;
    }

}
