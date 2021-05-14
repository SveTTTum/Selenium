package bringItOnTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "postform-text")
    By bySearchInputText = By.id("postform-text");
    private WebElement searchInputText;

//    @FindBy(id = "postform-text")
//    private WebElement searchInputText;

    public void openPage() {
        driver.get(HOMEPAGE_URL);
//        new WebDriverWait(driver, 10)
//                .until(CustomConditions.jQueryAJAXsCompleted());
    }

    public void inputCodeInNewPaste (String code) {
         WebElement inputCode = waitForElementLocatedBy(driver, bySearchInputText);
        inputCode.sendKeys(code);
    }



    private static WebElement waitForElementLocatedBy (WebDriver driver, By way) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(way));
    }
}
