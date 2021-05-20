package hurtMePlentyTask.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

    public class AbstractPage {
        WebDriver driver;

        AbstractPage (WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }
    }

