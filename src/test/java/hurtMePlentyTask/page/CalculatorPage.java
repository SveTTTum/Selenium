package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends AbstractPage{

    @FindBy(xpath = "//md-pagination-wrapper/md-tab-item[1]/div/div/div[1]/div/div")
    ////md-pagination-wrapper/md-tab-item[1]/div/div/div[1]/div/div
    private WebElement buttonActivateComputeEngine;

    public CalculatorPage (WebDriver driver) {
        super(driver);
    }

    public CalculatorPage activateComputeEngine() {
        buttonActivateComputeEngine.click();
        return this;
    }

}
