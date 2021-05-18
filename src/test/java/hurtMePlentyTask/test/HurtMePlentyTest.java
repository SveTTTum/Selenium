package hurtMePlentyTask.test;

import hurtMePlentyTask.page.CalculatorPage;
import hurtMePlentyTask.page.CloudGoogleHomePage;
import hurtMePlentyTask.page.CloudGoogleResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HurtMePlentyTest extends AbstractTest {

    @Test()
    public void setDataOnPage() {
        String textForSearchCalculator = "Google Cloud Platform Pricing Calculator";

        CalculatorPage pageHome = new CloudGoogleHomePage(driver)
                .openPage()
                .getSearchResults(textForSearchCalculator)
                .getPage()
                .activateComputeEngine();
    }

}