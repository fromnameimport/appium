package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdvancedOperationsMenu extends TestBase {
    static WebElement advancedPad = driver.findElement(By.id("pad_advanced"));
    static WebElement percent = driver.findElement(By.id("op_pct"));
    static WebElement factorial = driver.findElement(By.id("op_fact"));
    static WebElement power = driver.findElement(By.id("op_pow"));
    static WebElement sqrt = driver.findElement(By.id("op_sqrt"));
    // functions
    static WebElement sinus = driver.findElement(By.id("fun_sin"));
    static WebElement cosine = driver.findElement(By.id("fun_cos"));
    static WebElement tangent = driver.findElement(By.id("fun_tan"));
    static WebElement natLogarithm = driver.findElement(By.id("fun_ln"));
    static WebElement logarithm = driver.findElement(By.id("fun_log"));
    // spec chars & constants
    static WebElement piNum = driver.findElement(By.id("const_pi"));
    static WebElement eNum = driver.findElement(By.id("const_e"));
    static WebElement lParen = driver.findElement(By.id("lparen"));
    static WebElement rParen = driver.findElement(By.id("rparen"));
    // switch modes
    static WebElement inverseSwitchButton = driver.findElement(By.id("toggle_inv"));
    static WebElement degRadModeSwitchButton = driver.findElement(By.id("toggle_mode"));

    // waits
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(advancedPad));
    }

    //actions
    public void changeDegRadMode() {
        degRadModeSwitchButton.click();
    }
}
