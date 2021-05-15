package bringItOnTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPage extends AbstractPage{

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    By browserPageTitle = By.xpath("//div[@class='info-top']/h1");
    By syntax = By.xpath("//div[@class='left']/a");
    By codeResult = By.xpath("//div[@class='post-view']/textarea");

    public String headerOfPageResult(){
        return driver.findElement(browserPageTitle).getText();
    }

    public String syntaxOfPageResult() {
        return driver.findElement(syntax).getText();
    }

    public String codeOfPageResult(){
        return driver.findElement(codeResult).getText();
    }
}
