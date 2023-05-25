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
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pad_advanced"))));
    }

    //getters


    //actions
    public static void changeDegRadMode() {
        driver.findElement(By.id("toggle_mode")).click();
    }
    public static void changeInvMode() {
        driver.findElement(By.id("toggle_inv")).click();
    }
    public static void waitForInverseModeSwitch() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fun_arcsin"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fun_arccos"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fun_arctan"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fun_exp"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("fun_10pow"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("op_sqr"))));
    }
    public static void enterAdvancedOperator(String operator) {
        switch (operator) {
            case "%": driver.findElement(By.id("op_pct")).click(); break;
            case "sqrt": driver.findElement(By.id("op_sqrt")).click(); break;
            case "pow": driver.findElement(By.id("op_pow")).click(); break;
            case  "factorial": driver.findElement(By.id("op_fact")).click(); break;
        }
    }
    public static void useFunction(String function) {
        switch (function) {
            case "ln": driver.findElement(By.id("fun_ln")).click(); break;
            case "log": driver.findElement(By.id("fun_log")).click(); break;
            case "sin": driver.findElement(By.id("fun_sin")).click(); break;
            case "cos": driver.findElement(By.id("fun_cos")).click(); break;
            case "tan": driver.findElement(By.id("fun_tan")).click(); break;
        }
    }
    public static void enterConstant(String constant) {
        switch (constant) {
            case "pi": driver.findElement(By.id("const_pi")).click(); break;
            case "e": driver.findElement(By.id("const_e")).click(); break;
        }
    }
    public static void enterBrackets(String rightOrLeft) {
        switch (rightOrLeft) {
            case "right": driver.findElement(By.id("rparen")).click(); break;
            case "left": driver.findElement(By.id("lparen")).click(); break;
        }
    }
}
