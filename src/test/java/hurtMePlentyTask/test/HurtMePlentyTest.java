package hurtMePlentyTask.test;

import hurtMePlentyTask.page.CalculatorPage;
import hurtMePlentyTask.page.CloudGoogleHomePage;
import hurtMePlentyTask.page.TenMinuteMailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class HurtMePlentyTest extends AbstractTest {

    @Test()
    public void setDataOnPage() {
        String textForSearchCalculator = "Google Cloud Platform Pricing Calculator";

        CalculatorPage pageHome = new CloudGoogleHomePage(driver)
                .openPage()
                .getSearchResults(textForSearchCalculator)
                .getPage()
                .goToCalculatorFrame()
                .activateComputeEngine()
                .fillInstances("4")
                .chooseInstancesFor("")
                .chooseOperatingSystemOrSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .chooseMachineClass("Regular")
                .chooseSeries("N1")
                .chooseMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .fillAllFieldsGPUs(1, "NVIDIA Tesla V100")
                .chooseLocalSSD("2x375 GB")
                .chooseDatacenterLocation("Frankfurt")
                .chooseCommitedUsage("1 Year")
                .clickButtonAddToEstimate();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageHome.getVMClassResult(), "VM class: regular");
        softAssert.assertEquals(pageHome.getInstanceType(), "Instance type: n1-standard-8");
        softAssert.assertEquals(pageHome.getRegion(), "Region: Frankfurt");
        softAssert.assertEquals(pageHome.getLocalSSD(), "Total available local SSD space 2x375 GiB");
        softAssert.assertEquals(pageHome.getCommitmentTerm(), "Commitment term: 1 Year");
        softAssert.assertEquals(pageHome.getTotalCost(), "Estimated Component Cost: USD 1,082.77 per 1 month");
        softAssert.assertAll();

        String totalCostFromCalculatorPage = pageHome.getTotalCost();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        TenMinuteMailPage tenMinuteMailPage = new TenMinuteMailPage(driver);
        tenMinuteMailPage.openPage()
                .getRandomEmail();

        driver.switchTo().window(tabs.get(0));

        pageHome.goToCalculatorFrame()
                .sendEmail();

        driver.switchTo().window(tabs.get(1));

        tenMinuteMailPage.openLetter()
                .getTotalSumFromLetter();

        String totalCostFromLetter = tenMinuteMailPage.getTotalSumFromLetter();

        softAssert.assertTrue(totalCostFromCalculatorPage.contains(totalCostFromLetter));
    }
}