package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class TestBase {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static AndroidTouchAction actions;
    public static Dimension dimension;

    public static void initialization() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:platformVersion", "9.0");
        caps.setCapability("appium:deviceName", "Pixel XL");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("waitForIdleTimeout", 0);



        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        actions = new AndroidTouchAction(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static void swipe (String direction) {
        dimension = driver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;
        switch (direction) {
            case "RIGHT":
                startY = (dimension.height / 2);
                startX = (int) (dimension.width * 0.90);
                endX = (int) (dimension.width * 0.05);
                actions = new AndroidTouchAction(driver)
                        .press(point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(point(endX, startY))
                        .release()
                        .perform();
                break;
            case "LEFT":
                startY = (int) (dimension.height / 2);
                startX = (int) (dimension.width * 0.1);
                endX = (int) (dimension.width * 0.90);
                actions = new AndroidTouchAction(driver);
                actions.press(point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(point(endX, startY))
                        .release()
                        .perform();
                break;
            case "UP":
                startY = (int) (dimension.height * 0.1);
                startX = (int) (dimension.width / 2);
                endY = (int) (dimension.width * 0.90);
                actions = new AndroidTouchAction(driver)
                        .press(point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(point(endX, endY))
                        .release()
                        .perform();
                break;
            case "DOWN":
                startY = (int) (dimension.height * 0.90);
                startX = (int) (dimension.width / 2);
                endY = (int) (dimension.width * 0.1);
                actions = new AndroidTouchAction(driver);
                actions.press(point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                        .moveTo(point(endX, endY))
                        .release()
                        .perform();
                break;
        }
    }
    public static String calcForAssert(String num1, String num2, String operator) {
        String expectedResult = "";
        if (num1.contains(".") || num2.contains(".")) {
            switch (operator) {
                case "+": expectedResult = String.valueOf(Double.parseDouble(num1) + Double.parseDouble(num2)); break;
                case "-": expectedResult = String.valueOf(Double.parseDouble(num1) - Double.parseDouble(num2)); break;
                case "*":
                    if (num1.equals("0") || num2.equals("0")) {
                        expectedResult = "0";
                    } else expectedResult = String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2));
                    break;
                case "/":
                    if (num2.equals("0.0") || num2.equals("0")) {
                        expectedResult = "";
                    } else if (num1.equals("0")) {
                        expectedResult = "0";
                    } else {
                        expectedResult = String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2));
                    }
                    break;
            }
        } else {
            switch (operator) {
                case "+": expectedResult = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2)); break;
                case "-": expectedResult = String.valueOf(Long.parseLong(num1) - Long.parseLong(num2)); break;
                case "*": expectedResult = String.valueOf(Long.parseLong(num1) * Long.parseLong(num2)); break;
                case "/":
                    if (num2.equals("0.0") || num2.equals("0")) {
                        expectedResult = "";
                    } else if (num1.equals("0")) {
                        expectedResult = "0";
                    } else expectedResult = String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2));;
                    break;
            }

        }
        return expectedResult;
    }
}
