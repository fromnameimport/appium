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

    @DataProvider(name = "digitsForAddSubMulDiv")
    public Object[][] digitsForAddSubMulDiv() {
        return new Object[][] {
                {"3", "5"},
                {"10", "3"},
                {"13", "0"},
                {"-2345", "345"},
                {"0", "0.5"},
                {"46735672346", "1547457546"}
        };
    }

    @Test(dataProvider = "digitsForAddSubMulDiv")
    public void addition(String num1, String num2) {
        String expectedResult;
        if (num1.contains(".") || num2.contains(".")) {
            expectedResult = String.valueOf(Float.parseFloat(num1) + Float.parseFloat(num2));
        } else {
            expectedResult = String.valueOf(Long.parseLong(num1)+Long.parseLong(num2));
        }
        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("+");
        MainPage.enterDigit(num2);
        MainPage.equals();
        Assert.assertEquals(MainPage.getCalculusResult().replace(",", ""), expectedResult);
        MainPage.eraseCompletely();
    }
    @Test(dataProvider = "digitsForAddSubMulDiv")
    public void subtraction(String num1, String num2) throws UnsupportedEncodingException {

        MainPage.enterDigit(num1);
        MainPage.enterBasicOperator("-");
        MainPage.enterDigit(num2);
        MainPage.equals();

        String result = MainPage.getCalculusResult().replaceAll("[\\s,]", "");
        char result1Char = result.charAt(0);
        if (!(result1Char >= '0' && result1Char <= '9')) {
            result = result.substring(1);
        }

        if (num1.contains(".") || num2.contains(".")) {
            double expectedResult = Double.parseDouble(num1) - Double.parseDouble(num2);
            System.out.println(num1 + " " + num2);
            double actualResult = Double.parseDouble(result);
            Assert.assertEquals(expectedResult, actualResult);
        } else {
            System.out.println(num1 + " " + num2);
            long expectedResult = Long.parseLong(num1) - Long.parseLong(num2);
            long actualResult = Long.parseLong(result);
            Assert.assertEquals(expectedResult, actualResult);
        }
        MainPage.eraseCompletely();
    }
    @Test
    public void testTest() {
        MainPage.enterDigit("3");
        MainPage.enterBasicOperator("-");
        MainPage.enterDigit("5");
        MainPage.equals();
        System.out.println(MainPage.getCalculusResult().replaceAll("[\\s,]", ""));
    }
}
