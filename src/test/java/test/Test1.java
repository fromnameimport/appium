package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
        Assert.assertEquals(MainPage.getCurrentMode(), "RAD");
    }
    @Test
    public void test2() {
        MainPage.openAdvancedOperationsPad();
        AdvancedOperationsMenu.waitForPageVisibility();
    }

    @AfterTest
    public void quit() {
        tearDown();
    }
}
