package pl.alk.komputronik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HDDPage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> hddList;

    @FindBy(css = "a[ng-href='/advanced-configurator/power_supply']")
    private WebElement choosePowerSupplyButton;

    private WebDriver driver;

    public HDDPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HDDPage choosePowerSupplyButtonClick(){
        choosePowerSupplyButton.click();
        return this;
    }

    public HDDPage randomHDDProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(hddList.size());
        WebElement cpu = hddList.get(randomIndex);
        cpu.click();

        return this;
    }
}
