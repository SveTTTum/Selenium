package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleResultPage extends AbstractPage{

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a[@class='gs-title']")
    By linkCalculatorPageBy = By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a[@class='gs-title']");
    private WebElement linkCalculatorPage;
//
    CloudGoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage getPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(linkCalculatorPageBy)).click();
        return new CalculatorPage(driver);
    }
}
