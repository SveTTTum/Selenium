package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleResultPage extends AbstractPage{

    WebDriverWait wait = new WebDriverWait(driver, 5);

    By linkCalculatorPageBy = By.xpath("//div[@class='gs-title']/a[@class='gs-title' and @href='https://cloud.google.com/products/calculator']");

    CloudGoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage getPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(linkCalculatorPageBy)).click();
        return new CalculatorPage(driver);
    }
}
