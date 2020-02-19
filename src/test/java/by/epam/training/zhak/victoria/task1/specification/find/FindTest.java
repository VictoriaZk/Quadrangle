package by.epam.training.zhak.victoria.task1.specification.find;

import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTest {
    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle(
            new Point(2, 5),
            new Point(5, 10),
            new Point (15, 2),
            new Point( 1, 4)
    );


    @Test
    public void findById(){
        FindById findById = new FindById(1);
        boolean result = findById.specified(FIRST_QUADRANGLE);
        Assert.assertTrue(result);
    }

    @Test
    public void findByPerimeter(){
        FindByPerimeter findByPerimeter = new FindByPerimeter(12, 40);
        boolean result = findByPerimeter.specified(FIRST_QUADRANGLE);
        Assert.assertTrue(result);
    }

    @Test
    public void findBySquare(){
        FindBySquare findBySquare = new FindBySquare(26, 45);
        boolean result = findBySquare.specified(FIRST_QUADRANGLE);
        Assert.assertFalse(result);
    }

    @Test
    public void findByCoordinateXY(){
        FindByCoordinateXY findByCoordinateXY = new FindByCoordinateXY();
        boolean result = findByCoordinateXY.specified(FIRST_QUADRANGLE);
        Assert.assertTrue(result);
    }
}
