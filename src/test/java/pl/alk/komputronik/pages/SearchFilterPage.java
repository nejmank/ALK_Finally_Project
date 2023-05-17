package pl.alk.komputronik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pl.alk.komputronik.utils.SeleniumHelper;

import java.util.List;
import java.util.Random;

public class SearchFilterPage {

    @FindBys({@FindBy(xpath = "//div[@class='mt-10-mobile']"), @FindBy(xpath = "//div[@class='tests-product-entry']")})
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
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement product = productList.get(randomIndex);

        SeleniumHelper.scrollIntoView(driver, product.findElement(By.xpath("//div[contains(@class, 'grow w-full md')]")));
        SeleniumHelper.scrollDownIfElement1IsOverlappingElement2(driver, overlappingElement, seeMoreButton);

        WebElement seeMoreButtonOnRandomProduct = product.findElement(By.xpath("//div[contains(@class, 'grow w-full md')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", seeMoreButtonOnRandomProduct);
        return this;
    }


}
