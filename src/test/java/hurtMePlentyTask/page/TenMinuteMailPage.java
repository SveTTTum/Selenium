package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteMailPage extends AbstractPage{
    WebDriverWait wait = new WebDriverWait(driver, 20);
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//div[@id='copy_address']/span")
    private WebElement buttonForSaveRandomEmail;
    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement buttonOpenLetter;
    @FindBy(xpath = "//tr[@id='mobilepadding']//td[2]/h3")
    private WebElement totalEstimatedMonthlyCost;

    private By quantityLettersBy = By.xpath("//span[@id='inbox_count_number']");

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinuteMailPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TenMinuteMailPage getRandomEmail() {
        buttonForSaveRandomEmail.click();
        return this;
    }

    public TenMinuteMailPage openLetter() {
        wait.until(ExpectedConditions.textToBe(quantityLettersBy, "1"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonOpenLetter)).click();
        return this;
    }

    public String getTotalSumFromLetter() {
        return totalEstimatedMonthlyCost.getText();
    }

}
