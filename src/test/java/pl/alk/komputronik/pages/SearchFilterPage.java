package pl.alk.komputronik.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "/html/body/ktr-site/div/div[2]/div/div/ktr-product-list/div/ktr-transclude" +
            "/div[2]/div[2]/div[4]/div[1]/div[1]/div[4]/div[1]/button")
    private WebElement seeMoreButton;

    private WebDriver driver;
    public SearchFilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchFilterPage randomProductClick(){
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement product = productList.get(randomIndex);

        SeleniumHelper.scrollIntoView(driver, product);

        product.findElement(By.xpath(String.valueOf(seeMoreButton))).click();
        return this;
    }


}
