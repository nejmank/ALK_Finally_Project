package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//span[@class='title is-regular']")
    private WebElement myAccountButton;

    private WebDriver driver;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage myAccountButtonClick(){
        myAccountButton.click();
        return this;
    }
}
