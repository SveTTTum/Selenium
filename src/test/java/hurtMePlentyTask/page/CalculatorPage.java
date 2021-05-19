package hurtMePlentyTask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage{
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(xpath = "//md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']//descendant::div[@class='hexagon-in2']")
    private WebElement buttonActivateComputeEngine;

    @FindBy(xpath = "//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement selectInstances;

    @FindBy(xpath = "//input[@id='input_67']")
    private  WebElement fieldInstancesFor;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGPUs;

    String xpathfield = "//md-select-value[@id='select_value_label_%s']";
    String xpathElementOfField = "//md-option[@id='select_option_%s']//child::div";

    private By firstFrame = By.xpath("//iframe[starts-with(@name, 'goog_')]");
    private By operatingSystem = By.xpath(String.format(xpathElementOfField, 68));
    private By machineClass = By.xpath(String.format(xpathElementOfField, 81));
    private By series = By.xpath(String.format(xpathElementOfField, 195));
    private By machineType = By.xpath(String.format(xpathElementOfField, 376));
    private By GPUsNumber = By.xpath(String.format(xpathElementOfField, 415));
    private By GPUsType = By.xpath(String.format(xpathElementOfField, 422));
    private By localSSD = By.xpath(String.format(xpathElementOfField, 397));
    private By datacenterLocation = By.xpath(String.format(xpathElementOfField, 212));
    private By commitedUsage = By.xpath(String.format(xpathElementOfField, 100));
    private By buttonForAddToEstimate = By.xpath("//form[@class='ng-scope ng-valid-min ng-valid-max ng-dirty ng-valid-number ng-valid ng-valid-required ng-valid-parse']/div[15]/button");

    public CalculatorPage (WebDriver driver) {
        super(driver);
    }

    public CalculatorPage activateComputeEngine() {
        WebElement firstFrameBy = driver.findElement(firstFrame);
        driver.switchTo().frame(firstFrameBy);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.elementToBeClickable(buttonActivateComputeEngine)).click();
        return this;
    }

    public CalculatorPage fillInstances(String  numberOfInstances) {
        selectInstances.sendKeys(numberOfInstances);
        return this;
    }

    public CalculatorPage chooseInstancesFor(String instances) {
        fieldInstancesFor.click();
        fieldInstancesFor.sendKeys(instances);
        return this;
    }

    public CalculatorPage chooseOperatingSystemOrSoftware() {
        WebElement buttonForChooseOperatingSystem = driver.findElement(By.xpath(String.format(xpathfield, 59)));
        buttonForChooseOperatingSystem.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(operatingSystem)).click();
        return this;
    }

    public CalculatorPage chooseMachineClass() {
        WebElement buttonForChooseOperatingSystem = driver.findElement(By.xpath(String.format(xpathfield, 60)));
        buttonForChooseOperatingSystem.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(machineClass)).click();
        return this;
    }

    public CalculatorPage chooseSeries() {
        WebElement buttonForChooseSeries = driver.findElement(By.xpath(String.format(xpathfield, 62)));
        buttonForChooseSeries.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(series)).click();
        return this;
    }

    public CalculatorPage chooseMachineType() {
        WebElement buttonForChooseMachineType = driver.findElement(By.xpath(String.format(xpathfield, 63)));
        buttonForChooseMachineType.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(machineType)).click();
        return this;
    }

    public CalculatorPage fillAllFieldsGPUs() {
        addGPUs.click();
        WebElement buttonForChooseGPUsNumber = driver.findElement(By.xpath(String.format(xpathfield, 408)));
        buttonForChooseGPUsNumber.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(GPUsNumber)).click();
        WebElement buttonForChooseGPUsType = driver.findElement(By.xpath(String.format(xpathfield, 409)));
        buttonForChooseGPUsType.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(GPUsType)).click();
        return this;
    }

    public CalculatorPage chooseLocalSSD() {
        WebElement buttonForChooseLocalSSD = driver.findElement(By.xpath(String.format(xpathfield, 370)));
        buttonForChooseLocalSSD.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(localSSD)).click();
        return this;
    }

    public CalculatorPage chooseDatacenterLocation() {
        WebElement buttonForChooseDatacenterLocation = driver.findElement(By.xpath(String.format(xpathfield, 64)));
        buttonForChooseDatacenterLocation.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(datacenterLocation)).click();
        return this;
    }

    public CalculatorPage chooseCommitedUsage() {
        WebElement buttonForChooseCommitedUsage = driver.findElement(By.xpath(String.format(xpathfield, 65)));
        buttonForChooseCommitedUsage.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(commitedUsage)).click();
        return this;
    }

    public CalculatorPage clickButtonAddToEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForAddToEstimate)).click();
        return this;
    }

    //8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
    //9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.



}
