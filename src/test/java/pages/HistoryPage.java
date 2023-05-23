package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HistoryPage extends TestBase {
    // header menu
    static WebElement backButton = driver.findElement(By.id("mode"));
    static WebElement kebabMenu = driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"More options\"])[2]"));
    static WebElement clearButton = driver.findElement(By.id("title"));
    //history frame
    static WebElement historyDate = driver.findElement(By.id("history_date"));
    static WebElement historyFormula = driver.findElement(By.id("history_formula"));
    static WebElement historyResult = driver.findElement(By.id("history_result"));

    // waits
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("history_frame"))));
    }

    //getters
    public static String getHistoryDate() {
        return historyDate.getText();
    }
    public static String getHistoryFormula() {
        return historyFormula.getText();
    }
    public static String getHistoryResult() {
        return historyResult.getText();
    }

    //navigation
    public static void backToMainPage() {
        backButton.click();
    }

    //actions
    public static void clearHistory() {
        kebabMenu.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.TextView")));
        clearButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));
        driver.findElement(By.id("button1")).click();
    }
}
