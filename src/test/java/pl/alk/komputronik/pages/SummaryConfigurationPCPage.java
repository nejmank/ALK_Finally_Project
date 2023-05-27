package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryConfigurationPCPage {

    @FindBy(xpath = "//em[contains(text(),'Podsumowanie Twojego zestawu')]")
    private WebElement summaryPCLabel;

    private WebDriver driver;

    public SummaryConfigurationPCPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSummaryPCLabel(){
        return summaryPCLabel;
    }

}
