package by.epam.training.zhak.victoria.task1.action;

import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorTest {
    public static final double DELTA = 0.01;
    private Calculator calculator = new Calculator();

    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle (
            new Point(4,2), new Point(2,2),
            new Point(4,3), new Point(6,2)
    );

    private static final Quadrangle SECOND_QUADRANGLE = new Quadrangle (
            new Point(-6,1), new Point(2,5),
            new Point(4,-1), new Point(-4,-5)
    );

    private static final Quadrangle THIRD_QUADRANGLE = new Quadrangle (
            new Point(1,2), new Point(1,3),
            new Point(5,6), new Point(0,6)
    );

    @DataProvider(name = "calculateSideLength")
    public Object[][] dataForCalculateSide(){
        return new Object[][]{
                {FIRST_QUADRANGLE, 2.0},
                {THIRD_QUADRANGLE, 1.0}
        };
    }

    @DataProvider(name = "calculatePerimeter")
    public Object[][] dataForCalculatePerimeter() {
        return new Object[][]{
                {FIRST_QUADRANGLE, 8.47},
                {SECOND_QUADRANGLE, 30.53}
        };
    }

    @DataProvider(name = "calculateSquare")
    public Object[][] dataForCalculateSquare() {
        return new Object[][]{
                {FIRST_QUADRANGLE, 1.41},
                {SECOND_QUADRANGLE, 47.79}
        };
    }

    @Test(dataProvider = "calculateSideLength")
    public void calculateSideLength(Quadrangle quadrangle, final double expectedSideLength) {
        double actual = calculator.calculateSideLength(quadrangle.getPoints().get(0),quadrangle.getPoints().get(1));
        Assert.assertEquals(actual, expectedSideLength, DELTA);
    }

    @Test(dataProvider = "calculatePerimeter")
    public void calculatePerimeter(Quadrangle quadrangle, final double expectedPerimeter) {
        double actual = calculator.calculatePerimeterOfQuadrangle(quadrangle.getSides());
        Assert.assertEquals(actual, expectedPerimeter, DELTA);
    }

    @Test(dataProvider = "calculateSquare")
    public void calculateSquare(Quadrangle quadrangle, final double expectedSquare) {
        double actual = calculator.calculateSquareOfQuadrangle(quadrangle.getSides(), quadrangle.getDiagonals());
        Assert.assertEquals(actual, expectedSquare, DELTA);
    }
}