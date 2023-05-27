package pl.alk.komputronik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PowerSupplyPage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> powerSupplyList;

    @FindBy(css = "a[ng-href='/advanced-configurator/case']")
    private WebElement chooseCaseButton;

    private WebDriver driver;

    public PowerSupplyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PowerSupplyPage chooseCaseButtonClick(){
        chooseCaseButton.click();
        return this;
    }

    public PowerSupplyPage randomPowerSupplyProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(powerSupplyList.size());
        WebElement cpu = powerSupplyList.get(randomIndex);
        cpu.click();

        return this;
    }
}
