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

public class MotherboardPage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> motherboardList;

    @FindBy(xpath = "//a[contains(@href, 'dram')]")
    private WebElement chooseDRAMButton;

    private WebDriver driver;

    public MotherboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MotherboardPage chooseDRAMButtonClick(){
        chooseDRAMButton.click();
        return this;
    }

    public MotherboardPage randomMotherboardProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(motherboardList.size());
        WebElement cpu = motherboardList.get(randomIndex);
        cpu.click();

        return this;
    }
}
