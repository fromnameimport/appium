package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoreOptionsMenu extends TestBase {
    static WebElement historyButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]"));
    static WebElement openSourceLicensesButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]"));
    static WebElement menu = driver.findElement(By.className("android.widget.ListView"));
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(menu));
    }
    //navigation
    public static void goToHistoryPage() {
        historyButton.click();
        HistoryPage.waitForPageVisibility();
    }
    public static void goToOpenSourceLicenses() {
        openSourceLicensesButton.click();
    }
}
