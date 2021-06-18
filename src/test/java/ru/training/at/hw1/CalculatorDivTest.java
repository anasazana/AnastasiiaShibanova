package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @Test(dataProvider = "longValDivisionDataProvider")
    public void longValDivisionTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] longValDivisionDataProvider() {
        return new Object[][]{
            {15L, 5L, 3L},
            {2_700L, -5_400L, 0L},
            {-546_087_444L, -34L, 16_061_395L},
            {0L, 9_223_372_036L, 0L}
        };
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void longValDivisionByZeroTest() {
        calculator.div(123L, 0L);
    }

    @Test (dataProvider = "doubleValDivisionDataProvider")
    public void doubleValDivisionTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @DataProvider
    public Object[][] doubleValDivisionDataProvider() {
        return new Object[][]{
            {10.99, .01, 1099.0},
            {5, -2, -2.5},
            {-9.36e30, 7.64, -1.2251308900523561e30},
            {-9.85e11, -9.8e9, 100.51020408163265}
        };
    }

    @Test
    public void doubleValDivisionByZeroTest() {
        Assert.assertTrue(Double.isInfinite(calculator.div(2.35, 0.0)));
    }

}
