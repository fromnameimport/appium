package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdvancedOperationsMenu;
import pages.MainPage;

import java.net.MalformedURLException;

public class AdvancedOperationsTest extends TestBase {
    @BeforeTest
    public void init() throws MalformedURLException {
        initialization();
    }
    @AfterTest
    public void quit() {
        tearDown();
    }

    @Test
    void percentage() {
        MainPage.enterDigit("100");
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.enterAdvancedOperator("%");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("50");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "50");
        MainPage.eraseCompletely();
    }
    @Test
    void factorial() {
        MainPage.enterDigit("3");
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.enterAdvancedOperator("factorial");
        TestBase.swipe("LEFT");

        Assert.assertEquals(MainPage.getCalculusResult(), "6");
        MainPage.eraseCompletely();
    }
    @Test
    void power() {
        MainPage.enterDigit("5");
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.enterAdvancedOperator("pow");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("2");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "25");
        MainPage.eraseCompletely();
    }
    @Test
    void sqrt() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.enterAdvancedOperator("sqrt");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("81");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "9");
        MainPage.eraseCompletely();
    }
    @Test
    void sin() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.useFunction("sin");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("60");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "-0.304810621102");
        MainPage.eraseCompletely();
    }
    @Test
    void cos() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.useFunction("cos");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("30");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "0.1542514498875");
        MainPage.eraseCompletely();
    }
    @Test
    void tan() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.useFunction("tan");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("45");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "1.6197751905438");
        MainPage.eraseCompletely();
    }
    @Test
    void ln() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.useFunction("ln");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("1");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "0");
        MainPage.eraseCompletely();
    }
    @Test
    void log() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.useFunction("log");
        TestBase.swipe("LEFT");
        MainPage.waitForPageVisibility();
        MainPage.enterDigit("10");
        MainPage.equals();

        Assert.assertEquals(MainPage.getCalculusResult(), "1");
        MainPage.eraseCompletely();
    }
}
