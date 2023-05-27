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

public class DRAMPage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> DRAMList;

    @FindBy(xpath = "//a[contains(@href, 'hdd')]")
    private WebElement chooseHDDButton;

   private WebDriver driver;

    public DRAMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DRAMPage chooseHDDButtonClick(){
        chooseHDDButton.click();
        return this;
    }

    public DRAMPage randomDRAMProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(DRAMList.size());
        WebElement cpu = DRAMList.get(randomIndex);
        cpu.click();

        return this;
    }
}
