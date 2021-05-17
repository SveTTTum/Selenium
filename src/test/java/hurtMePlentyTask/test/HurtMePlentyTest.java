package hurtMePlentyTask.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HurtMePlentyTest extends AbstractTest {
    private WebDriver driver;
    String textForSearchCalculator = "Google Cloud Platform Pricing Calculator";

    @Test()
    public void setDataOnPage() {
        pageHome.openPage()
        .getSearchResults(textForSearchCalculator)
        .activateComputeEngine();

    }

}