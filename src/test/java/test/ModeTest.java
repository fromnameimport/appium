package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdvancedOperationsMenu;
import pages.MainPage;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class ModeTest extends TestBase {
    @BeforeTest
    public void init() throws MalformedURLException {
        initialization();
    }
    @AfterTest
    public void quit() {
        tearDown();
    }

    @Test (priority = 1)
    public void radToDegModeTest() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.changeDegRadMode();
        Assert.assertEquals(MainPage.getCurrentMode(), "DEG");
        TestBase.swipe("RIGHT");
    }
    @Test (priority = 2)
    public void degToRadModeTest() {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.changeDegRadMode();
        Assert.assertEquals(MainPage.getCurrentMode(), "RAD");
        TestBase.swipe("RIGHT");
    }

    @Test (priority = 3)
    public void invertModeTest() throws InterruptedException {
        MainPage.openAdvancedOperations();
        AdvancedOperationsMenu.waitForPageVisibility();
        AdvancedOperationsMenu.changeInvMode();
        AdvancedOperationsMenu.waitForInverseModeSwitch();
        TestBase.swipe("RIGHT");
    }
}
