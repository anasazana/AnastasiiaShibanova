package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AbstractCalculatorTest {

    @Test(dataProvider = "longValMultiplicationDataProvider")
    public void longValMultiplicationTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] longValMultiplicationDataProvider() {
        return new Object[][]{
            {15L, 8L, 120L},
            {-2_300L, 8_600L, -19_780_000L},
            {0L, 0L, 0L},
            {9_223_372_036L, 0L, 0L}
        };
    }

    @Test (dataProvider = "doubleValMultiplicationDataProvider")
    public void doubleValMultiplicationTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @DataProvider
    public Object[][] doubleValMultiplicationDataProvider() {
        return new Object[][]{
            {1.5, 3.0, 4.5},
            {-2.2, 2.0, -4.4},
            {0.0, 0.0, 0.0},
            {9.85e10, 30, 2.955e12}
        };
    }
}
