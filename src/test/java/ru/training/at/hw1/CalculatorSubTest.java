package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractCalculatorTest {

    @Test(dataProvider = "longValSubtractionDataProvider")
    public void longValSubtractionTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] longValSubtractionDataProvider() {
        return new Object[][]{
            {15L, 7L, 8L},
            {-5_000, 8_000_000, -8_005_000},
            {0, 0, 0},
            {5_222, -9_333, 14_555}
        };
    }

    @Test (dataProvider = "doubleValSubtractionDataProvider")
    public void doubleValSubtractionTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @DataProvider
    public Object[][] doubleValSubtractionDataProvider() {
        return new Object[][]{
            {.05, 1.65, -1.6},
            {-10.99, -.01, -10.98},
            {0.0, 0.0, 0.0},
            {9.85e11, 9.8e9, 9.752e11}
        };
    }
}
