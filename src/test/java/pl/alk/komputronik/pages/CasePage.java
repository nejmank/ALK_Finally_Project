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

public class CasePage {

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'Dodaj do zestawu')]")
    })
    private List<WebElement> caseList;

    @FindBy(xpath = "//a[contains(text(),'Przejdź do podsumowania')]")
    private WebElement goToSummaryButton;

    private WebDriver driver;

    public CasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CasePage goToSummaryButtonClick(){
        goToSummaryButton.click();
        return this;
    }

    public CasePage randomCaseProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//button[contains(text(),'Dodaj do zestawu')]"), 3));
        Random random = new Random();
        int randomIndex = random.nextInt(caseList.size());
        WebElement cpu = caseList.get(randomIndex);
        cpu.click();

        return this;
    }
}
