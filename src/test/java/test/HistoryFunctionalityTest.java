package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HistoryPage;
import pages.MainPage;

import java.net.MalformedURLException;

public class HistoryFunctionalityTest extends TestBase {
    @BeforeTest
    public void init() throws MalformedURLException {
        initialization();
    }
    @AfterTest
    public void quit() {
        tearDown();
    }

    @Test(priority = 1)
    public void storingOneOperationInHistory() throws InterruptedException {
        MainPage.enterDigit("13");
        MainPage.enterBasicOperator("+");
        MainPage.enterDigit("23");
        String formula = MainPage.getFormula();
        MainPage.equals();
        String result = MainPage.getCalculusResult();

        TestBase.swipe("UP");
        HistoryPage.waitForPageVisibility();

        Assert.assertEquals(HistoryPage.getHistoryResult(), result);
        Assert.assertEquals(HistoryPage.getHistoryFormula(), formula);
        TestBase.swipe("DOWN");
    }

    @Test(priority = 2, enabled = false)
    public void clearHistory() throws InterruptedException {
        TestBase.swipe("UP");
        HistoryPage.waitForPageVisibility();
        // ExceptionInInitializerError
        HistoryPage.clearHistory();
        Assert.assertEquals(HistoryPage.getHistoryResult(), "");
        Assert.assertEquals(HistoryPage.getHistoryFormula(), "");
    }
}
