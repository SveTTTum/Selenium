package bringItOnTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    WebDriver driver;
    AbstractPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    private static WebElement waitForElementLocatedBy (WebDriver driver, By way) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(way));
    }
}
