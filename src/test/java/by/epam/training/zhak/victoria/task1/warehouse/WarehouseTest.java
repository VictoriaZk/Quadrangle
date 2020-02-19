package by.epam.training.zhak.victoria.task1.warehouse;


import by.epam.training.zhak.victoria.task1.action.Calculator;
import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import by.epam.training.zhak.victoria.task1.entity.Warehouse;
import by.epam.training.zhak.victoria.task1.observer.QuadrangleEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WarehouseTest {
    private Warehouse warehouse;
    private Calculator calculator;

    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle(
            new Point(2, 3),
            new Point(6, 4),
            new Point(10, 2),
            new Point(15, 2)
    );

    @BeforeClass
    public void setUp() {
        warehouse = new Warehouse();
        calculator = new Calculator();
        FIRST_QUADRANGLE.addObserver(warehouse);
        warehouse.handleEvent((new QuadrangleEvent(FIRST_QUADRANGLE)));
    }

    @Test
    public void handleEventId(){
        long actualId = FIRST_QUADRANGLE.getId();
        long expectedId = warehouse.getId();
        Assert.assertEquals(actualId, expectedId);
    }

    @Test
    public void handleEventPerimeter(){
        double actualPerimeter = calculator.calculatePerimeterOfQuadrangle(FIRST_QUADRANGLE.getSides());
        double expectedPerimeter = warehouse.getPerimeter();
        Assert.assertEquals(actualPerimeter,expectedPerimeter);
    }

    @Test
    public void handleEventSquare(){
        double actualSquare = calculator.calculateSquareOfQuadrangle(FIRST_QUADRANGLE.getSides(),
                FIRST_QUADRANGLE.getDiagonals());
        double expectedSquare = warehouse.getSquare();
        Assert.assertEquals(actualSquare,expectedSquare);
    }
}
