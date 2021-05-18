package bringItOnTask.test;

import bringItOnTask.page.PastebinHomePage;
import bringItOnTask.page.PastebinResultPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BringItOnTaskTest extends AbstractTest {

    @Test()
    public void checkHeaderOnNewPage() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String name = "how to gain dominance among developers";
        PastebinResultPage pageHome = new PastebinHomePage(driver)
                .openPage()
                .inputCodeInNewPaste(code)
                .chooseSyntaxBash()
                .chooseExpiration()
                .pasteName(name)
                .saveResults();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageHome.getHeader(), name);
        softAssert.assertEquals(pageHome.getSyntax(), "Bash");
        softAssert.assertEquals(pageHome.getCode(), code);
        softAssert.assertAll();
    }
}
