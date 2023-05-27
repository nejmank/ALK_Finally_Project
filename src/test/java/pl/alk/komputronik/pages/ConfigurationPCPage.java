package pl.alk.komputronik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationPCPage {

    @FindBy(css = "h1[class^='font-headline']")
    private WebElement configurationPCLabel;

    @FindBy(css = "a[ng-href='/advanced-configurator/cpu']")
    private WebElement chooseCPUButton;



    private WebDriver driver;
    public ConfigurationPCPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ConfigurationPCPage chooseCPUButtonClick(){
        chooseCPUButton.click();
        return this;
    }

    public WebElement getConfigurationPCLabel(){
        return configurationPCLabel;
    }


}
