package bringItOnTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinResultPage extends AbstractPage {

    private final By browserPageTitle = By.xpath("//div[@class='info-top']/h1");
    private final By syntax = By.xpath("//div[@class='left']/a");
    private final By codeResult = By.xpath("//div[@class='post-view']/textarea[@class='textarea']");

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        WebElement header = waitForElementLocatedBy(driver, browserPageTitle);
        return header.findElement(browserPageTitle).getText();
    }

    public String getSyntax() {
        WebElement syntaxElement = waitForElementLocatedBy(driver, syntax);
        return syntaxElement.findElement(syntax).getText();
    }

    public String getCode() {
        WebElement textCodeResult = waitForElementLocatedBy(driver, codeResult);
        return textCodeResult.findElement(codeResult).getText();
    }
}
