package by.epam.training.zhak.victoria.task1.specification.sort;

import by.epam.training.zhak.victoria.task1.entity.Point;
import by.epam.training.zhak.victoria.task1.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest {
    private static final Quadrangle FIRST_QUADRANGLE = new Quadrangle(
            new Point(12,3),
            new Point( 10, 7),
            new Point( 7, 4),
            new Point(1, 1)
    );

    private static final Quadrangle SECOND_QUADRANGLE = new Quadrangle(
            new Point(10, 5),
            new Point(2, 4),
            new Point(23, 22),
            new Point(122, 0)
    );

    @Test
    public void sortById() {
        SortById sortById = new SortById();
        int result = sortById.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void sortByName() {
       SortByName sortByName = new SortByName();
       int result = sortByName.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
       Assert.assertEquals(result, -1);
    }

    @Test
    public void sortByCoordinateX(){
        SortByCoordinateX sortByCoordinateX = new SortByCoordinateX();
        int result = sortByCoordinateX.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        Assert.assertEquals(result, 1 );
    }

    @Test
    public void sortByCoordinateY(){
        SortByCoordinateY sortByCoordinateY = new SortByCoordinateY();
        int result = sortByCoordinateY.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        Assert.assertEquals(result, -1);
    }
}
