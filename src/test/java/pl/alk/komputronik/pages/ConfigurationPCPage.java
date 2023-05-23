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

    @FindBy(css = "a[ng-href='/advanced-configurator/graphics_card']")
    private WebElement chooseGPUButton;

    @FindBy(css = "a[ng-href='/advanced-configurator/motherboard']")
    private WebElement chooseMotherboardButton;

    @FindBy(css = "a[ng-href='/advanced-configurator/dram_memory']")
    private WebElement chooseDRAMButton;

    @FindBy(css = "a[ng-href='/advanced-configurator/hdd']")
    private WebElement chooseHDDButton;

    @FindBy(css = "a[ng-href='/advanced-configurator/power_supply']")
    private WebElement choosePowerSupplyButton;

    @FindBy(css = "a[ng-href='/advanced-configurator/case']")
    private WebElement chooseCaseButton;
    private WebDriver driver;
    public ConfigurationPCPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ConfigurationPCPage chooseCPUButtonClick(){
        chooseCPUButton.click();
        return this;
    }

    public ConfigurationPCPage chooseGPUButtonClick(){
        chooseGPUButton.click();
        return this;
    }

    public ConfigurationPCPage chooseMotherboardButtonClick(){
        chooseMotherboardButton.click();
        return this;
    }

    public ConfigurationPCPage chooseDRAMButtonClick(){
        chooseDRAMButton.click();
        return this;
    }

    public ConfigurationPCPage chooseHDDButtonClick(){
        chooseHDDButton.click();
        return this;
    }

    public ConfigurationPCPage choosePowerSupplyButtonClick(){
        choosePowerSupplyButton.click();
        return this;
    }

    public ConfigurationPCPage chooseCaseButtonClick(){
        chooseCaseButton.click();
        return this;
    }


}
