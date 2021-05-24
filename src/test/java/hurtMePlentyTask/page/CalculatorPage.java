package hurtMePlentyTask.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

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
    @FindBy(xpath = "//md-card-content[@id='resultBlock']//button[@id='email_quote']")
    private WebElement buttonEmailEstimate;
    @FindBy(xpath = "//div[@class='md-dialog-container ng-scope']//md-input-container//label[contains(text(), 'Email')]//following-sibling::input")
    private WebElement fieldForEmail;
    @FindBy(xpath = "//md-dialog-actions[@class='layout-row']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement buttonSendEmail;
    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement emailBy;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_59']")
    private WebElement buttonForChooseOperatingSystem;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']")
    private WebElement buttonForChooseMachineClass;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_62']")
    private WebElement buttonForChooseSeries;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_63']")
    private WebElement buttonForChooseMachineType;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_408']")
    private WebElement buttonForChooseGPUsNumber;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_409']")
    private WebElement buttonForChooseGPUsType;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_370']")
    private WebElement buttonForChooseLocalSSD;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_64']")
    private WebElement buttonForChooseDatacenterLocation;
    @FindBy(xpath = "//md-select-value[@id='select_value_label_65']")
    private WebElement buttonForChooseCommitedUsage;
    @FindBy(xpath = "//div[contains(@layout-align, 'end start')]/button[not(@disabled='disabled')]")
    private WebElement buttonForAddToEstimate;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(text(), 'VM class: ')]")
    private WebElement vmClassResult;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy']//div[contains(text(), 'Instance type: ')]")
    private WebElement instanceTypeResult;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy']//div[contains(text(), 'Region: ')]")
    private WebElement regionResult;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(text(), 'Total available local SSD space ')]")
    private WebElement localSSDResult;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy ng-scope']//div[contains(text(), 'Commitment term: ')]")
    private WebElement commitmentTermResult;
    @FindBy(xpath = "//md-list-item[@class='md-1-line md-no-proxy']/div[@class='md-list-item-text']/b[@class='ng-binding']")
    private WebElement estimatedCostResult;

    String xpathElementOfField = "//div[contains(@class, 'md-select-menu-container md-active')]//div[contains(@class, 'md-text') and contains(text(), '%s')]";

    private By firstFrame = By.xpath("//iframe[starts-with(@name, 'goog_')]");

    public CalculatorPage (WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToCalculatorFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        return this;
    }

    public CalculatorPage activateComputeEngine() {
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

    public CalculatorPage chooseOperatingSystemOrSoftware(String systemName) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseOperatingSystem)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, systemName)))).click();
        return this;
    }

    public CalculatorPage chooseMachineClass(String className) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseMachineClass)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, className)))).click();
        return this;
    }

    public CalculatorPage chooseSeries(String seriesName) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseSeries)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, seriesName)))).click();
        return this;
    }

    public CalculatorPage chooseMachineType(String machineTypeName) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseMachineType)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, machineTypeName)))).click();
        return this;
    }

    public CalculatorPage fillAllFieldsGPUs(int numberGPUs, String typeGPUs) {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUs)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseGPUsNumber)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, numberGPUs)))).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseGPUsType)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, typeGPUs)))).click();
        return this;
    }

    public CalculatorPage chooseLocalSSD(String localSSD) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseLocalSSD)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, localSSD)))).click();
        return this;
    }

    public CalculatorPage chooseDatacenterLocation(String centerLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseDatacenterLocation)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpathElementOfField, centerLocation)))).click();
        return this;
    }

    public CalculatorPage chooseCommitedUsage(String commitedUsage) {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForChooseCommitedUsage)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpathElementOfField, commitedUsage)))).click();
        return this;
    }

    public CalculatorPage clickButtonAddToEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonForAddToEstimate)).click();
        return this;
    }

    public String getVMClassResult() {
        return vmClassResult.getText();
    }

    public String getInstanceType() {
        return instanceTypeResult.getText();
    }

    public String getRegion() {
        return regionResult.getText();
    }

    public String getLocalSSD() {
        return localSSDResult.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTermResult.getText();
    }

    public String getTotalCost() {
        return estimatedCostResult.getText();
    }

    public CalculatorPage sendEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonEmailEstimate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldForEmail)).click();
        try {
            String email = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            fieldForEmail.sendKeys(email);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(buttonSendEmail)).click();
        return this;
    }
}
