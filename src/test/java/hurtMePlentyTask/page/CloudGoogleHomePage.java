package hurtMePlentyTask.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='devsite-search-container']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement stringForSearch;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudGoogleResultPage getSearchResults(String text) {
        buttonSearch.click();
        stringForSearch.sendKeys(text + Keys.ENTER);
        return new CloudGoogleResultPage(driver);
    }

    //или можно сразу выбрать нужную страницу Calculator
//    public CalculatorPage getSearchResults(String text) {
//        By linkForSearchCalculator = By.xpath("//div[@id='suggestion-product-0']/a");
//        buttonSearch.click();
//        stringForSearch.sendKeys(text);
//        wait.until(ExpectedConditions.presenceOfElementLocated(linkForSearchCalculator)).click();
//        return new CalculatorPage(driver);
//    }

}
