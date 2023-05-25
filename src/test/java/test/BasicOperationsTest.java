package test;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MainPage;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

public class BasicOperationsTest extends TestBase {
    @BeforeTest
    public void init() throws MalformedURLException {
        initialization();
    }
    @AfterTest
    public void quit() {
        tearDown();
    }
    @BeforeMethod
    void test() throws InterruptedException {
        Thread.sleep(100);
    }

    @DataProvider(name = "digitsForAddSubMulDiv")
    public Object[][] digitsForAddSubMulDiv() {
        return new Object[][] {
                {"3", "5"},
                {"10", "3"},
                {"13", "0"},
                {"0", "0.5"},
                {"4673567", "1547457"}
        };
    }

    @Test(priority = 1, dataProvider = "digitsForAddSubMulDiv")
    public void addition(String num1, String num2) {
        String expectedResult = TestBase.calcForAssert(num1, num2, "+");

        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("+");
        MainPage.enterDigit(num2);
        MainPage.equals();

        String actualResult = MainPage.getCalculusResult();
        Assert.assertEquals(actualResult, expectedResult);

        MainPage.eraseCompletely();
    }
    @Test(priority = 2, dataProvider = "digitsForAddSubMulDiv")
    public void subtraction(String num1, String num2) throws InterruptedException {
        String expectedResult = TestBase.calcForAssert(num1, num2, "-");

        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("-");
        MainPage.enterDigit(num2);
        MainPage.equals();

        String actualResult = MainPage.getCalculusResult();

        Assert.assertEquals(actualResult, expectedResult);

        MainPage.eraseCompletely();
    }
    @Test(priority = 3, dataProvider = "digitsForAddSubMulDiv")
    public void multiplication(String num1, String num2) {
        String expectedResult = TestBase.calcForAssert(num1, num2, "*");

        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("*");
        MainPage.enterDigit(num2);
        MainPage.equals();

        String actualResult = MainPage.getCalculusResult();

        Assert.assertEquals(actualResult, expectedResult);

        MainPage.eraseCompletely();
    }
    @Test(priority = 4, dataProvider = "digitsForAddSubMulDiv")
    public void division(String num1, String num2) {
        String expectedResult = TestBase.calcForAssert(num1, num2, "/");

        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("/");
        MainPage.enterDigit(num2);
        MainPage.equals();

        String actualResult = MainPage.getCalculusResult();

        // use substring due to the different number formats of java double and calculator result
        Assert.assertEquals(actualResult, expectedResult.substring(0, actualResult.length()));

        MainPage.eraseCompletely();
    }
}
