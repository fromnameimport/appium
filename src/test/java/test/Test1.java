package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdvancedOperationsMenu;
import pages.MainPage;

import java.net.MalformedURLException;

public class Test1 extends TestBase {
    @BeforeTest
    public void init() throws MalformedURLException {
        initialization();
    }

    @Test
    public void test1() {
        MainPage.waitForPageVisibility();
        System.out.println(MainPage.getFormula());
        Assert.assertEquals(MainPage.getCurrentMode(), "RAD");
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.changeDegRadMode();
        MainPage.closeAdvancedOperations();
        Assert.assertEquals(MainPage.getCurrentMode(), "DEG");
    }

    @AfterTest
    public void quit() {
        tearDown();
    }
}
