package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage extends TestBase {
    // header menu
    static WebElement backButton = driver.findElement(By.id("mode"));
    static WebElement kebabMenu = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout"));
    static WebElement clearButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout"));
    //history frame
    static WebElement historyPage = driver.findElement(By.id("history_frame"));
    static WebElement historyDate = driver.findElement(By.id("history_date"));
    static WebElement historyFormula = driver.findElement(By.id("history_formula"));
    static WebElement historyResult = driver.findElement(By.id("history_result"));

    // confirmation pop-up menu
    static String messageId = "message";
    static String confirmButtonId = "button1";
    static String declineButtonId = "button2";

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
    public static void clearHistory() throws InterruptedException {
        kebabMenu.click();
        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOf(clearButton));
        clearButton.click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(messageId))));
        Thread.sleep(1000);
        driver.findElement(By.id(confirmButtonId)).click();
    }
}
