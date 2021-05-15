package bringItOnTask.test;

import bringItOnTask.page.AbstractPage;
import bringItOnTask.page.PastebinHomePage;
import bringItOnTask.page.PastebinResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BringItOnTaskTest extends AbstractTest{
    private WebDriver driver;
    String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n";
    String name = "how to gain dominance among developers";


    @Test()
    public void setDataOnPage() {
        pageHome.openPage()
                .inputCodeInNewPaste(code)
                .chooseSyntaxBash()
                .chooseExpiration()
                .pasteName(name)
                .saveResults();
    }
    @Test()
    public  void checkHeaderOnNewPage() {
        String headerResultPage = pageHome.openPage()
                .inputCodeInNewPaste(code)
                .pasteName(name)
                .saveResults()
                .headerOfPageResult();
        Assert.assertEquals(headerResultPage, name);
    }

    @Test()
    public  void checkSyntaxOnNewPage() {
        String syntaxResultPage = pageHome.openPage()
                .inputCodeInNewPaste(code)
                .pasteName(name)
                .chooseSyntaxBash()
                .saveResults()
                .syntaxOfPageResult();
        Assert.assertEquals(syntaxResultPage, "Bush");
    }

    @Test()
    public  void checkCodeOnNewPage() {
        String codeResultPage = pageHome.openPage()
                .inputCodeInNewPaste(code)
                .pasteName(name)
                .saveResults()
                .codeOfPageResult();
        Assert.assertEquals(codeResultPage, code);
    }

}
