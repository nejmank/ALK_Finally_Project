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

public class GPUPage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> gpuList;

    @FindBy(xpath = "//a[contains(@href, 'motherboard')]")
    private WebElement chooseMotherboardButton;


    private WebDriver driver;

    public GPUPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GPUPage chooseMotherboardButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(chooseMotherboardButton));
        chooseMotherboardButton.click();
        return this;
    }

    public GPUPage randomGPUProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(gpuList.size());
        WebElement cpu = gpuList.get(randomIndex);
        cpu.click();

        return this;
    }
}
