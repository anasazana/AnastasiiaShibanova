package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test (dataProvider = "longValAdditionDataProvider")
    public void longValAdditionTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] longValAdditionDataProvider() {
        return new Object[][]{
            {3L, 5L, 8L},
            {3_000_000, -8_000_000, -5_000_000},
            {0, 0, 0},
            {-5_222_000, -9_333_000, -14_555_000}
        };
    }

    @Test (dataProvider = "doubleValAdditionDataProvider")
    public void doubleValAdditionTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @DataProvider
    public Object[][] doubleValAdditionDataProvider() {
        return new Object[][]{
            {.05, 1.65, 1.7},
            {-10.99, -.01, -11.0},
            {0.0, 0.0, 0.0},
            {9, -7.64, 1.36}
        };
    }

}
