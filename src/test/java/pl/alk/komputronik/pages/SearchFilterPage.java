package pl.alk.komputronik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchFilterPage {

    @FindAll({
            @FindBy(xpath = "//a[contains(text(),'Zobacz więcej')]")
    })
    private List<WebElement> productList;

    @FindBy(xpath = "//div[contains(@class, 'grow w-full md')]")
    private WebElement seeMoreButton;

    @FindBy(xpath = "//div[contains(@class, 'justify-end')]")
    private WebElement overlappingElement;

    private WebDriver driver;
    public SearchFilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchFilterPage randomProductClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//a[contains(text(),'Zobacz więcej')]"), 5));
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement product = productList.get(randomIndex);
        product.click();

        return this;
    }


}
