package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenSourceLicensesPage extends TestBase {
    static WebElement openSourceLicensesPage = driver.findElement(By.id("decor_content_parent"));
    static WebElement backButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));

    //waits
    public static void waitForPageVisibility() {
        wait.until(ExpectedConditions.visibilityOf(openSourceLicensesPage));
    }

    //navigation
    public static void backToMainPage() {
        backButton.click();
        MainPage.waitForPageVisibility();
    }
}
