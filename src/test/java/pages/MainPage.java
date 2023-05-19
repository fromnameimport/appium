package pages;

import base.TestBase;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

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
    public static void openAdvancedOperations() {
        advancedOperationsMenu.click();
        AdvancedOperationsMenu.waitForPageVisibility();
    }
    public static void closeAdvancedOperations() {
        digit7.click();
        MainPage.waitForPageVisibility();
    }
    public static void openMoreOptionsMenu() {
        kebabMenu.click();
        MoreOptionsMenu.waitForPageVisibility();
    }
    public static void closeMoreOptionsMenu() {
        digit7.click();
        MoreOptionsMenu.waitForPageVisibility();
    }

    //getters
    public static String getCurrentMode() {
        return currentMode.getText();
    }
    public static String getFormula() { return formula.getText();}
    public static String getCalculusResult() {
        return result.getText();
    }

    //actions
    public static void enterDigit(String digit) {
        String[] split = digit.split("");
        for (String s : split) {
            switch (s) {
                case "0": digit0.click(); break;
                case "1": digit1.click(); break;
                case "2": digit2.click(); break;
                case "3": digit3.click(); break;
                case "4": digit4.click(); break;
                case "5": digit5.click(); break;
                case "6": digit6.click(); break;
                case "7": digit7.click(); break;
                case "8": digit8.click(); break;
                case "9": digit9.click(); break;
                case ".": decPoint.click(); break;
                case "-": sub.click(); break;
            }
            System.out.println(s);
        }
    }
    public static void enterBasicOperator(String operator) {
        switch (operator) {
            case "+": add.click(); break;
            case "-": sub.click(); break;
            case "*": mul.click(); break;
            case "/": div.click(); break;
        }
    }
    public static void equals() { equal.click(); }
    public static void eraseDigitFromFormula() { delete.click(); }
    public static void eraseCompletely() {
        actions.press(PointOption.point(delete.getLocation()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release()
                .perform();
    }

}
