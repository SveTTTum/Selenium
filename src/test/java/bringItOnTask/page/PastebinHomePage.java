package bringItOnTask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//div[@class='form-group field-postform-text required']/textarea[@id = 'postform-text']")
    private WebElement inputText;

    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    private WebElement buttonForChooseSyntax;

    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']//li[contains(text(), 'Bash')]")
    private WebElement chooseSyntax;

    @FindBy(xpath ="//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']")
    private WebElement buttonExpiration;

    @FindBy(xpath ="//span[@class='select2-results']//li[contains(text(), '10 Minutes')]")
    private WebElement chooseExpiration;

    @FindBy(id = "postform-name")
    private WebElement inputName;

    @FindBy(xpath ="//button[@class='btn -big']")
    private WebElement buttonCreateNewPaste;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage inputCodeInNewPaste (String code) {
        inputText.sendKeys(code);
        return this;
    }

    public PastebinHomePage chooseSyntaxBash() {
        buttonForChooseSyntax.click();
        chooseSyntax.click();
        return this;
    }

    public PastebinHomePage chooseExpiration() {
        buttonExpiration.click();
        chooseExpiration.click();
        return this;
    }

    public PastebinHomePage pasteName (String name) {
        inputName.sendKeys(name);
        return this;
    }

    public PastebinResultPage saveResults() {
        buttonCreateNewPaste.click();
        return new PastebinResultPage(driver);
    }

}
