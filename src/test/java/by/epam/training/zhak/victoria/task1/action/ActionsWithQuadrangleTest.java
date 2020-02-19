package by.epam.training.zhak.victoria.task1.action;

import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ActionsWithQuadrangleTest {
    private ActionsWithQuadrangle actionsWithQuadrangle = new ActionsWithQuadrangle();

    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle (
            new Point(4,2), new Point(2,2),
            new Point(4,3), new Point(6,2)
    );

    private static final Quadrangle SECOND_QUADRANGLE = new Quadrangle (
            new Point(0,0), new Point(0,4),
            new Point(2,4), new Point(2,0)
    );

    private static final Quadrangle THIRD_QUADRANGLE = new Quadrangle (
            new Point(-6,1), new Point(2,5),
            new Point(4,-1), new Point(-4,-5)
    );



    @DataProvider(name = "arePointsCreateQuadrangle")
    public Object[][] dataForArePointsCreateQuadrangle() {
        return new Object[][]{
                {FIRST_QUADRANGLE,false},
                {SECOND_QUADRANGLE,true}
        };
    }

    @DataProvider(name="checkIsQuadrangleTrapezium")
    public Object[][]dataForCheckIsQuadrangleTrapezium(){
        return new Object[][]{
                {FIRST_QUADRANGLE,false},
                {THIRD_QUADRANGLE,false}
        };
    }

    @DataProvider(name = "checkIsQuadrangleSquare")
    public Object[][]dataForCheckIsQuadrangleSquare(){
        return new Object[][]{
                {SECOND_QUADRANGLE,false},
                {THIRD_QUADRANGLE,false}
        };
    }

    @DataProvider(name = "checkIsQuadrangleRhombus")
    public Object[][]dataForCheckIsQuadrangleRhombus(){
        return new Object[][]  {
                {FIRST_QUADRANGLE,false},
                {SECOND_QUADRANGLE,false}
        };
    }

    @Test(dataProvider = "arePointsCreateQuadrangle")
    public void arePointsCreateQuadrangle(Quadrangle quadrangle, final boolean expectedSituetedPoints) {
        boolean actual = actionsWithQuadrangle.arePointsCreateQuadrangle(quadrangle.getPoints()) ;
        Assert.assertEquals(actual, expectedSituetedPoints);
    }

    @Test(dataProvider = "checkIsQuadrangleTrapezium")
    public void checkIsQuadrangleTrapezium(Quadrangle quadrangle, final boolean expectedSituetedPoints) {
        boolean actual = actionsWithQuadrangle.checkIsQuadrangleTrapezium(quadrangle.getSides()) ;
        Assert.assertEquals(actual, expectedSituetedPoints);
    }

    @Test(dataProvider = "checkIsQuadrangleSquare")
    public void checkIsQuadrangleSquare(Quadrangle quadrangle, final boolean expectedSituetedPoints) {
        boolean actual = actionsWithQuadrangle.checkIsQuadrangleSquare(quadrangle.getSides(), quadrangle.getDiagonals());
        Assert.assertEquals(actual, expectedSituetedPoints);
    }

    @Test(dataProvider = "checkIsQuadrangleRhombus")
    public void checkIsQuadrangleRhombus(Quadrangle quadrangle, final boolean expectedSituetedPoints) {
        boolean actual = actionsWithQuadrangle.checkIsQuadrangleRhombus(quadrangle.getSides(), quadrangle.getDiagonals());
        Assert.assertEquals(actual, expectedSituetedPoints);
    }
}