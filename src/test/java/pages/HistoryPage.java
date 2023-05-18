package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HistoryPage extends TestBase {
    static WebElement historyFrame = driver.findElement(By.id("history_frame"));
    // header menu
    static WebElement backButton = driver.findElement(By.id("mode"));
    static WebElement kebabMenu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]"));
    static WebElement clearButton = driver.findElement(By.className("android.widget.TextView"));
    //history frame
    static WebElement historyDate = driver.findElement(By.id("history_date"));
    static WebElement historyFormula = driver.findElement(By.id("history_formula"));
    static WebElement historyResult = driver.findElement(By.id("history_result"));

    // waits
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(historyFrame));
    }

    //getters
    public String getHistoryDate() {
        return historyDate.getText();
    }
    public String getHistoryFormula() {
        return historyFormula.getText();
    }
    public String getHistoryResul() {
        return historyResult.getText();
    }

    //navigation
    public void backToMainPage() {
        backButton.click();
        MainPage.waitForPageVisibility();
    }

    //actions
    public void clearHistory() {
        kebabMenu.click();
        wait.until(ExpectedConditions.visibilityOf(clearButton));
        clearButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("buttonPanel"))));
        driver.findElement(By.id("button1")).click();
    }
}
