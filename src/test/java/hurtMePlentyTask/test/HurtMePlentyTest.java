package hurtMePlentyTask.test;

import hurtMePlentyTask.page.CalculatorPage;
import hurtMePlentyTask.page.CloudGoogleHomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlentyTest extends AbstractTest {

    @Test()
    public void setDataOnPage() {
        String textForSearchCalculator = "Google Cloud Platform Pricing Calculator";

        CalculatorPage pageHome = new CloudGoogleHomePage(driver)
                .openPage()
                .getSearchResults(textForSearchCalculator)
                .getPage()
                .activateComputeEngine()
                .fillInstances("4")
                .chooseInstancesFor("")
                .chooseOperatingSystemOrSoftware()
                .chooseMachineClass()
                .chooseSeries()
                .chooseMachineType()
                .fillAllFieldsGPUs()
                .chooseLocalSSD()
                .chooseDatacenterLocation()
                .chooseCommitedUsage()
                .clickButtonAddToEstimate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageHome.getVMClassResult(), "VM class: regular");
        softAssert.assertEquals(pageHome.getInstanceType(), "Instance type: n1-standard-8");
        softAssert.assertEquals(pageHome.getRegion(), "Region: Frankfurt");
        softAssert.assertEquals(pageHome.getLocalSSD(), "Total available local SSD space 2x375 GiB");
        softAssert.assertEquals(pageHome.getCommitmentTerm(), "Commitment term: 1 Year");
        softAssert.assertEquals(pageHome.getEstimatedComponentCost(), "Estimated Component Cost: USD 1,082.77 per 1 month");
        softAssert.assertAll();
    }
}