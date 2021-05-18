package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage{
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']")
    ////md-pagination-wrapper/md-tab-item[1]/div/div/div[1]/div/div
    private WebElement buttonActivateComputeEngine;
    private By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");

    public CalculatorPage (WebDriver driver) {
        super(driver);
    }

    public CalculatorPage activateComputeEngine() {
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.elementToBeClickable(buttonActivateComputeEngine)).click();
        return this;
    }

}
