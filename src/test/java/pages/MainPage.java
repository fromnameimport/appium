package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends TestBase {
    static WebElement display = driver.findElement(By.id("display"));
    static WebElement result = display.findElement(By.id("result"));
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
        wait.until(ExpectedConditions.visibilityOf(display));
    }

    //navigation
    public static void openAdvancedOperationsPad() {
        advancedOperationsMenu.click();
        AdvancedOperationsMenu.waitForPageVisibility();
    }
    public static void openMoreOptionsMenu() {
        kebabMenu.click();
        MoreOptionsMenu.waitForPageVisibility();
    }

    //getters
    public static String getCurrentMode() {
        return currentMode.getText();
    }
    public static String getCalculusResult() {
        return result.getText();
    }
}
