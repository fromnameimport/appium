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
    public static void changeDegRadMode() {
        degRadModeSwitchButton.click();
    }
    public static void changeInvMode() {
        inverseSwitchButton.click();
    }
    public static void enterAdvancedOperator(String operator) {
        switch (operator) {
            case "%": percent.click(); break;
            case "sqrt": sqrt.click(); break;
            case "pow": power.click(); break;
            case  "factorial": factorial.click(); break;
        }
    }
    public static void useFunction(String function) {
        switch (function) {
            case "ln": natLogarithm.click(); break;
            case "log": logarithm.click(); break;
            case "sin": sinus.click(); break;
            case "cos": cosine.click(); break;
            case "tan": tangent.click(); break;
        }
    }
    public static void enterConstant(String constant) {
        switch (constant) {
            case "pi": piNum.click(); break;
            case "e": eNum.click(); break;
        }
    }
    public static void enterBrackets(String rightOrLeft) {
        switch (rightOrLeft) {
            case "right": rParen.click(); break;
            case "left": lParen.click(); break;
        }
    }
}
