package pages;

import base.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class MainPage extends TestBase {
    static WebElement display = driver.findElement(By.id("display"));
    static WebElement result = driver.findElement(By.id("result"));
    static WebElement formula = driver.findElement(By.id("formula"));
    // menus
    static WebElement kebabMenu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]"));
    static WebElement advancedOperationsMenu = driver.findElement(By.id("pad_advanced"));
    //digits
    static WebElement digit0 = driver.findElement(By.id("digit_0"));
    static WebElement digit1 = driver.findElement(By.id("digit_1"));
    static WebElement digit2 = driver.findElement(By.id("digit_2"));
    static WebElement digit3 = driver.findElement(By.id("digit_3"));
    static WebElement digit4 = driver.findElement(By.id("digit_4"));
    static WebElement digit5 = driver.findElement(By.id("digit_5"));
    static WebElement digit6 = driver.findElement(By.id("digit_6"));
    static WebElement digit7 = driver.findElement(By.id("digit_7"));
    static WebElement digit8 = driver.findElement(By.id("digit_8"));
    static WebElement digit9 = driver.findElement(By.id("digit_9"));
    //operators
    static WebElement div = driver.findElement(By.id("op_div"));
    static WebElement mul = driver.findElement(By.id("op_mul"));
    static WebElement sub = driver.findElement(By.id("op_sub"));
    static WebElement add = driver.findElement((By.id("op_add")));
    static WebElement equal = driver.findElement(By.id("eq"));

    static WebElement decPoint = driver.findElement(By.id("dec_point"));
    // modes
    static WebElement currentMode = driver.findElement(By.id("mode"));
    // delete & clear
    static WebElement delete = driver.findElement(By.id("del"));
//    static WebElement clear = driver.findElement(By.id("clr"));

    // waits
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("display"))));
    }

    //navigation
    public static void openAdvancedOperations() {
        driver.findElement(By.id("pad_advanced")).click();
        AdvancedOperationsMenu.waitForPageVisibility();
    }
    public static void closeAdvancedOperations() {
        driver.findElement(By.id("digit_7")).click();
        MainPage.waitForPageVisibility();
    }
    public static void openMoreOptionsMenu() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")).click();
    }
    public static void closeMoreOptionsMenu() {
        driver.findElement(By.id("digit_7")).click();
    }

    //getters
    public static String getCurrentMode() {
        return driver.findElement(By.id("mode")).getText();
    }
    public static String getFormula() { return driver.findElement(By.id("formula")).getText();}
    public static String getCalculusResult() {
//        if (driver.findElement(By.id("result")).getText().contains("−")) {
//            return driver.findElement(By.id("result")).getText().replace(",", "").replace("−", "-");
//        }
//        return driver.findElement(By.id("result")).getText().replace(",", "");
        return driver.findElement(By.id("result")).getText().replace(",", "").replace("−", "-");
    }

    //actions
    public static void enterDigit(String digit) {
        String[] split = digit.split("");
        for (String s : split) {
            switch (s) {
                case "0": driver.findElement(By.id("digit_0")).click(); break;
                case "1": driver.findElement(By.id("digit_1")).click(); break;
                case "2": driver.findElement(By.id("digit_2")).click(); break;
                case "3": driver.findElement(By.id("digit_3")).click(); break;
                case "4": driver.findElement(By.id("digit_4")).click(); break;
                case "5": driver.findElement(By.id("digit_5")).click(); break;
                case "6": driver.findElement(By.id("digit_6")).click(); break;
                case "7": driver.findElement(By.id("digit_7")).click(); break;
                case "8": driver.findElement(By.id("digit_8")).click(); break;
                case "9": driver.findElement(By.id("digit_9")).click(); break;
                case ".": driver.findElement(By.id("dec_point")).click(); break;
                case "-":
                    if (MainPage.getFormula().endsWith("−")) {
                        driver.findElement((By.id("op_add"))).click();
                    } else driver.findElement(By.id("op_sub")).click();
                    break;
            }
        }
    }
    public static void enterBasicOperator(String operator) {
        switch (operator) {
            case "+": driver.findElement((By.id("op_add"))).click(); break;
            case "-": driver.findElement(By.id("op_sub")).click(); break;
            case "*": driver.findElement(By.id("op_mul")).click(); break;
            case "/": driver.findElement(By.id("op_div")).click(); break;
        }
    }
    public static void equals() { driver.findElement(By.id("eq")).click(); }
    public static void eraseDigitFromFormula() { driver.findElement(By.id("del")).click(); }
    public static void eraseCompletely() {
        PointOption pointOption = PointOption.point(driver.findElement(By.id("del")).getLocation());
        actions.longPress(pointOption)
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .release();
//        try {
//            actions.longPress(PointOption.point(driver.findElement(By.id("del")).getLocation()))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//                    .release();
//        } catch (NoSuchElementException e) {
//            driver.findElement(AppiumBy.accessibilityId("clear")).click();
//        }
    }
}
