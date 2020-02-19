package by.epam.training.zhak.victoria.task1.validation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidationTest {
    private Validation validation = new Validation();

    @DataProvider(name = "dataForIsValidPositive")
    public Object[][] dataForIsValidPositive() {
        return new Object[][]{
                {"2 0 0 0 2 0 1 0 1 0 1 1"},
                {"-1 2 3 2 2 1 2.23 2 4.6 1.08 -0.94 2.87"},
                {"-2 0 -1 0 -3 -1 1.6 0.23 -1 -0.13 -0.92 1.94"}
        };
    }

    @DataProvider(name = "dataForIsValidNegative")
    public Object[][] dataForIsValidNegative() {
        return new Object[][]{
                {"2 0 0 0 2 0 1 0 1 0 1 1 2.0 8.96 45.36 78.36"},
                {"2 0 0 0 2"},
                {"-1 2 3 2 2 1 2.23 2 4.6 1.08 -0.94 2.87d"}
        };
    }

    @Test(dataProvider = "dataForIsValidPositive")
    public void isValidPositive(String lines) {
        boolean actual = validation.isValid(lines);
        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "dataForIsValidNegative")
    public void isValidNegative(String lines) {
        boolean actual = validation.isValid(lines);
        Assert.assertFalse(actual);
    }

}